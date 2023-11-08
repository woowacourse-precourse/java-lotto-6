package lotto.view;

import lotto.enums.InputMessage;

public class InputView {
    public static void printPayAmountInputMessage() {
        System.out.println(InputMessage.PAY_AMOUNT_INPUT_MESSAGE.getMessage());
    }

    public static void printJackpotNumberInputMessage() {
        System.out.println();
        System.out.println(InputMessage.JACKPOT_NUMBER_INPUT_MESSAGE.getMessage());
    }

    public static void printBonusNumberInputMessage() {
        System.out.println();
        System.out.println(InputMessage.BONUS_NUMBER_INPUT_MESSAGE.getMessage());
    }
}
