package lotto.view;


import java.util.List;
import java.util.Map;
import lotto.constants.OutputMessages;
import lotto.constants.WinningResult;
import lotto.domain.Lotto;

public class OutputView {


    public static void askPurchaseAmount() {
        OutputMessages message = OutputMessages.ASK_PURCHASE_AMOUNT_MESSAGE;
        System.out.println(message.getMessage());
    }

    public static void printLottoList(List<Lotto> lottoList) {
        String message = "\n" + lottoList.size() + OutputMessages.PURCHASED_LOTTO_COUNT_MESSAGE.getMessage();
        System.out.println(message);

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void askWinningNumbers() {
        OutputMessages message = OutputMessages.ASK_WINNING_NUMBER_MESSAGE;
        System.out.println(message.getMessage());
    }

    public static void askBonusNumber() {
        OutputMessages message = OutputMessages.ASK_BONUS_NUMBER_MESSAGE;
        System.out.println(message.getMessage());
    }


    public static void printSuccessResult() {
        OutputMessages message = OutputMessages.WINNING_STATISTICS_MESSAGE;
        System.out.println(message.getMessage());
    }

    public static void printProfitRate(double profitRate) {
        System.out.println(OutputMessages.TOTAL_PROFIT_RATE_MESSAGE.getMessage() + String.format("%.1f", profitRate)
                + OutputMessages.PERCENT_PROFIT_RATE_MESSAGE.getMessage());
    }

    public static void printResult(Map<WinningResult, Integer> result) {
        for (int i = 1; i < WinningResult.values().length; i++) {
            System.out.println(WinningResult.values()[i].getMessage() + " - " + result.get(WinningResult.values()[i])
                    + OutputMessages.UNIT_MESSAGE.getMessage());
        }
    }


}
