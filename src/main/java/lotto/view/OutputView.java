package lotto.view;

import lotto.message.GameMessage;
import lotto.message.ResultMessage;
import lotto.model.Lotto;
import lotto.model.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String FREFIX = "[";
    private static final String SUFFIX = "]";

    public static void printLottoResult(int amount, List<Lotto> lottos) {
        String message = String.format(GameMessage.LOTTO_AMOUNT.getMessage(), amount);
        System.out.println(message);

        for (Lotto lotto: lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResultStatistics(Map<LottoRank, Integer> result) {
        System.out.println(GameMessage.RESULT_STATISTICS.getMessage());

        String message = String.format(ResultMessage.FIFTH.getMessage(), result.get(LottoRank.FIFTH));
        System.out.println(message);
        message = String.format(ResultMessage.FOURTH.getMessage(), result.get(LottoRank.FOURTH));
        System.out.println(message);
        message = String.format(ResultMessage.THIRD.getMessage(), result.get(LottoRank.THIRD));
        System.out.println(message);
        message = String.format(ResultMessage.SECOND.getMessage(), result.get(LottoRank.SECOND));
        System.out.println(message);
        message = String.format(ResultMessage.FIRST.getMessage(), result.get(LottoRank.FIRST));
        System.out.println(message);
    }

    public static void printProfitPercentage(Double profitPercentage) {
        String message = String.format(GameMessage.PROFIT_PERCENTAGE.getMessage(), profitPercentage * 100);
        System.out.println(message);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
