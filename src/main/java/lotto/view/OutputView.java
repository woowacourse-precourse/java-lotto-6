package lotto.view;

import lotto.constants.Grade;
import lotto.constants.OutputMessage;

public class OutputView {

    private static final String HORIZONTAL_RULE = "---";

    public static void printMoneyInputMessage() {
        System.out.println(OutputMessage.MONEY_INPUT_MESSAGE.getMessage());
    }

    public static void printLottoPurchaseCount(int count) {
        System.out.printf((OutputMessage.LOTTO_PURCHASE_COUNT_MESSAGE.getMessage()), count);
        System.out.println();
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

    public static void printHorizontalRule() {
        System.out.println(HORIZONTAL_RULE);
    }

    public static void printResult(Grade grade, int count) {
        System.out.printf(grade.getMessage(), count);
        System.out.println();
    }

    public static void printEarningRate(double earningRate) {
        System.out.printf(OutputMessage.EARNING_RATE_MESSAGE.getMessage(), earningRate);
        System.out.println();
    }
}
