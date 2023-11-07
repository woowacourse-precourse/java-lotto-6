package lotto.view;


import java.util.List;
import lotto.constants.OutputMessages;
import lotto.model.Lotto;

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
}
