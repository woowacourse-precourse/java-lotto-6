package lotto.view;

import static lotto.constant.MessageConstants.DIVIDER;
import static lotto.constant.MessageConstants.PURCHASE_SUCCESS;
import static lotto.constant.MessageConstants.RANK_COUNT_FORMAT;
import static lotto.constant.MessageConstants.TOTAL_EARNING_RATE_FORMAT;
import static lotto.constant.MessageConstants.WINNING_STATISTICS;
import static lotto.constant.NumberConstants.ONE_HUNDRED;

import java.util.List;
import lotto.domain.LottoRank;
import lotto.domain.Member;

public class LottoOutputView {

    public static void showPurchasedLotto(Member member) {
        System.out.println(member.calculateQuantity() + PURCHASE_SUCCESS);
        member.lottos()
                .forEach(System.out::println);
    }

    public static void showGameResult(Member member, List<LottoRank> results) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVIDER);

        for (LottoRank rank : LottoRank.findValidRanks()) {
            long count = rank.calculateCount(results);
            System.out.printf(RANK_COUNT_FORMAT, rank.getMessage(), count);
        }

        double earningRate = calculateRate(LottoRank.calculate(results), member.inputMoney());
        System.out.printf(TOTAL_EARNING_RATE_FORMAT, earningRate);
    }

    private static double calculateRate(long profit, long inputMoney) {
        return (double) (profit * ONE_HUNDRED) / inputMoney;
    }

}
