package view;

import constants.OutputMessage;

public class OutputView {
    public static void printMoneyInputMessage() {
        System.out.println(OutputMessage.MONEY_INPUT_MESSAGE.getMessage());
    }

    public static void printAnswerLottoNumberInputMessage() {
        System.out.println(OutputMessage.ANSWER_LOTTO_INPUT_MESSAGE.getMessage());
    }

    public static void printBonusNumberInputMessage() {
        System.out.println(OutputMessage.BONUS_NUMBER_INPUT_MESSAGE.getMessage());
    }

    public static void printLottoResultMessage() {
        System.out.println(OutputMessage.LOTTO_RESULT_MESSAGE.getMessage());
    }
}
