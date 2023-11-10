package lotto.io;

import java.util.List;
import lotto.constants.LottoRank;
import lotto.domains.Lotto;
import lotto.messages.OutputMessage;

public class Output {

    public static void showPurchasedLottos(List<Lotto> lottos) {
        OutputMessage outputMessage = OutputMessage.LOTTO_TICKETS_PURCHASED;
        int number = lottos.size();
        System.out.println(String.format(outputMessage.getOutputView(), number));

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void showWinningStatistics(int[] result) {
        OutputMessage outputMessage = OutputMessage.WINNING_STATISTICS;
        System.out.println(outputMessage.getOutputView());

        for (int i = 5; i >= 1; i--) {
            LottoRank lottoRank = getLottoRankByRank(i);

            String description = lottoRank.getDescription().toString();
            int number = result[i];

            System.out.println(String.format(description, number));
        }
    }

    public static void showRateOfReturn(int[] result, int purchaseAmount) {
        long totalMoney = 0;
        for (int i = 5; i >= 1; i--) {
            LottoRank lottoRank = getLottoRankByRank(i);
            long money = lottoRank.getMoney();
            int number = result[i];
            totalMoney += (money * number);
        }
        double rateOfMoney = ((double) totalMoney / purchaseAmount) * 100;

        OutputMessage outputMessage = OutputMessage.RATE_OF_RETURN;
        System.out.println(String.format(outputMessage.getOutputView(), rateOfMoney));
    }

    private static LottoRank getLottoRankByRank(int rank) throws IllegalArgumentException {
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.getRank() == rank) {
                return lottoRank;
            }
        }
        return null;
    }

}
