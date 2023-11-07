package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.domain.Ranking.*;

import lotto.domain.Lotto;
import lotto.domain.Ranking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private static final String PURCHASE_X_COUNT = "개를 구매했습니다.";

    public String makePurchaseResultOutputStatement(int count) {
        StringBuilder result = new StringBuilder();
        result.append(count).append(PURCHASE_X_COUNT + "\n");

        List<Lotto> lottoList = generateLottoList(count);

        for (Lotto lotto : lottoList) {
            result.append(lotto.getStatus()).append("\n");
        }

        return result.toString();
    }

    public List<Lotto> generateLottoList(int count) {
        List<Lotto> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            result.add(generateLotto());
        }

        return result;
    }

    public Lotto generateLotto() {
        List<Integer> list = generateLottoCombination();
        return new Lotto(list);
    }

    public List<Integer> generateLottoCombination() {
        List<Integer> list = pickUniqueNumbersInRange(1, 45, 6);
        list.sort(null);
        return list;
    }

    public Ranking calculateRanking(Lotto target, Lotto answer, int bonusNumber) {
        int count = target.countMatchingNumber(answer);

        if (count == 3) {
            return FIFTH;
        }

        if (count == 4) {
            return FORTH;
        }

        if (count == 5 && !target.isNumberIn(bonusNumber)) {
            return THIRD;
        }

        if (count == 5 && target.isNumberIn(bonusNumber)) {
            return SECOND;
        }

        if (count == 6) {
            return FIRST;
        }

        return SIXTH;
    }

    public Map<Ranking, Integer> initWinningResult() {
        Map<Ranking, Integer> winningResult = new HashMap<>();

        for (Ranking ranking : Ranking.values()) {
            winningResult.put(ranking, 0);
        }

        return winningResult;
    }

}
