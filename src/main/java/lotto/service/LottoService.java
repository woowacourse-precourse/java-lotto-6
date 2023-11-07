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

public class LottoService {
    public static final String PURCHASE_X_COUNT = "개를 구매했습니다.";
    public static final String WINNING_STATISTICS = "당첨 통계";

    private Map<Ranking, Integer> winningResult;

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

    public void initWinningResult() {
        winningResult = new HashMap<>();

        for (Ranking ranking : Ranking.values()) {
            winningResult.put(ranking, 0);
        }
    }

    public void makeWinningResult(List<Lotto> lottoList, Lotto answer, int bonusNumber) {
        initWinningResult();

        for (Lotto lotto : lottoList) {
            Ranking ranking = calculateRanking(lotto, answer, bonusNumber);
            int value = winningResult.getOrDefault(ranking, 0);
            winningResult.put(ranking, value + 1);
        }
    }

    public double calculateProfitRate() {
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

    public String makeWinningResultOutputStatement(List<Lotto> lottoList, Lotto answer, int bonusNumber) {
        // winningResult에 경기 결과 기록하기
        makeWinningResult(lottoList, answer, bonusNumber);

        StringBuilder result = new StringBuilder();

        result.append(WINNING_STATISTICS).append("\n");
        result.append("---").append("\n");

        // 등수별 당첨 수 나타내는 부분
        result.append(winningResultToOutputStatement());

        // 수익률 계산하고 원하는 형태로 표시하는 부분
        result.append(String.format("총 수익률은 %.1f%%입니다.", calculateProfitRate()));

        return result.toString();
    }

    private String winningResultToOutputStatement() {
        StringBuilder result = new StringBuilder();

        Ranking[] rankingsArr = new Ranking[]{FIFTH, FORTH, THIRD, SECOND, FIRST};

        for (Ranking ranking : rankingsArr) {
            result.append(ranking.getLotteryResult()).append(" - ");
            result.append(winningResult.get(ranking)).append("개").append("\n");
        }

        return result.toString();
    }


    public Map<Ranking, Integer> getWinningResult() {
        return winningResult;
    }
}
