package lotto;


import lotto.Utils.LottoConstantNumbers;
import lotto.Utils.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.Utils.LottoConstantNumbers.*;
import static lotto.Utils.Message.*;


public class RankJudge {
    private final List<Integer> userNumbers;
    private final Map<LottoConstantNumbers, Message> rankMessages;
    private int bonusNumber;
    private int totalPrize;
    private int investment;

    public RankJudge(List<Integer> userNumbers, int bonusNumber, int investment) {
        this.userNumbers = userNumbers;
        this.bonusNumber = bonusNumber;
        this.totalPrize = 0;
        this.investment = investment;
        this.rankMessages = new HashMap<>();
        initializeRankMessages();
    }

    private void initializeRankMessages() {
        rankMessages.put(FIFTH_RANK, FIFTH_RANK_MESSAGE);
        rankMessages.put(FOURTH_RANK, FOURTH_RANK_MESSAGE);
        rankMessages.put(THIRD_RANK, THIRD_RANK_MESSAGE);
        rankMessages.put(SECOND_RANK, SECOND_RANK_MESSAGE);
        rankMessages.put(FIRST_RANK, FIRST_RANK_MESSAGE);
    }

    public void checkAndPrintResults(ComputerLotto computerLottos) {
        Map<LottoConstantNumbers, Integer> results = new HashMap<>();
        results.put(FIFTH_RANK, 0);
        results.put(FOURTH_RANK, 0);
        results.put(THIRD_RANK, 0);
        results.put(SECOND_RANK, 0);
        results.put(FIRST_RANK, 0);

        for (Lotto lotto : computerLottos.getComputerLottos()) {
            int matchCount = lotto.countMatchingNumbers(userNumbers);
            boolean bonusMatch = lotto.bonusNumberMatch(bonusNumber);

            // 1등: 6개 일치
            if (matchCount == 6) {
                results.put(FIRST_RANK, results.get(FIRST_RANK) + 1);
                totalPrize += FIRST_RANK.getValue();
            }
            // 2등: 5개 일치 + 보너스 번호
            if (matchCount == 5 && bonusMatch) {
                results.put(SECOND_RANK, results.get(SECOND_RANK) + 1);
                totalPrize += SECOND_RANK.getValue();
            }
            // 3등: 5개 일치
            if (matchCount == 5 && !bonusMatch) {
                results.put(THIRD_RANK, results.get(THIRD_RANK) + 1);
                totalPrize += THIRD_RANK.getValue();
            }
            // 4등: 4개 일치
            if (matchCount == 4) {
                results.put(FOURTH_RANK, results.get(FOURTH_RANK) + 1);
                totalPrize += FOURTH_RANK.getValue();
            }
            // 5등: 3개 일치
            if (matchCount == 3) {
                results.put(FIFTH_RANK, results.get(FIFTH_RANK) + 1);
                totalPrize += FIFTH_RANK.getValue();
            }
        }
        printResults(results);
        printProfitRate();
    }

    private void printResults(Map<LottoConstantNumbers, Integer> results) {
        System.out.println(START_RANK.getValue());
        for (LottoConstantNumbers rank : LottoConstantNumbers.values()) {
            if (results.get(rank) != null) {
                System.out.println(rankMessages.get(rank).getValue() + results.get(rank) + "개");
            }
        }
    }

    private void printProfitRate() {
        double profitRate = ((double) totalPrize / (double) investment) * 100;
        profitRate = Math.round(profitRate * 10) / 10.0; // 소수점 두 번째 자리에서 반올림
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
