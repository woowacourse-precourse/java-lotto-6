package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.domain.Ranking.*;
import static lotto.utils.CalculationUtils.*;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {

    public Lotto generateLotto() {
        List<Integer> list = generateLottoCombination();
        return new Lotto(list);
    }

    public List<Lotto> generateLottoList(int count) {
        List<Lotto> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            result.add(generateLotto());
        }

        return result;
    }

    public List<Integer> generateLottoCombination() {
        List<Integer> result = pickUniqueNumbersInRange(1, 45, 6);
        result = result.stream()
                .sorted()
                .collect(Collectors.toList());
        return result;
    }

    public Ranking calculateRanking(Lotto target, Lotto answer, int bonusNumber) {
        int count = target.countMatchingNumber(answer);

        if (count == 3) { return FIFTH; }

        if (count == 4) { return FORTH; }

        if (count == 5 && !target.isNumberIn(bonusNumber)) { return THIRD; }

        if (count == 5 && target.isNumberIn(bonusNumber)) { return SECOND; }

        if (count == 6) { return FIRST; }

        return SIXTH;
    }

    public Map<Ranking, Integer> initWinningResult() {
        Map<Ranking, Integer> winningResult = new HashMap<>();

        for (Ranking ranking : Ranking.values()) {
            winningResult.put(ranking, 0);
        }

        return winningResult;
    }

    public Map<Ranking, Integer> calculateWinningResult(List<Lotto> lottoList, Lotto answer, int bonusNumber) {
        Map<Ranking, Integer> winningResult = initWinningResult();

        for (Lotto lotto : lottoList) {
            Ranking ranking = calculateRanking(lotto, answer, bonusNumber);
            int value = winningResult.getOrDefault(ranking, 0);
            winningResult.put(ranking, value + 1);
        }

        return winningResult;
    }

    public double calculateProfitRate(Map<Ranking,Integer> winningResult) {
        int totalPrizeMoney = 0;
        int totalCount = 0;

        for (Ranking ranking : winningResult.keySet()) {
            int curCount = winningResult.get(ranking);
            totalCount += curCount;
            totalPrizeMoney += (ranking.getPrizeMoney() * curCount);
        }

        int inputMoney = totalCount * 1000;

        double profitRate = (totalPrizeMoney / (double) inputMoney) * 100;

        return roundToDecimalPlace(profitRate, 1);
    }

}
