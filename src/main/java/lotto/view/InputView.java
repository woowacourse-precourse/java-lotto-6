package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.contants.InputMessage;

public class InputView {

    public static String getPurchaseAmountFromInput() {
        System.out.println(InputMessage.PURCHASE_AMOUNT.getValue());
        return inputRemoveBlank(Console.readLine());
    }

    public static String getWinningLottoFromInput() {
        System.out.println(InputMessage.WINNING_LOTTO.getValue());
        return inputRemoveBlank(Console.readLine());
    }

    public static String getBonusNumberFromInput() {
        System.out.println(InputMessage.BONUS.getValue());
        return inputRemoveBlank(Console.readLine());
    }

    public static String inputRemoveBlank(String input) {
        return input.replace(" ", "");
    }
}
