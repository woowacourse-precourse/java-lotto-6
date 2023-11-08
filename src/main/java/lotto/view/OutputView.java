package lotto.view;

import static lotto.util.ConstantList.LOTTO_CUT_LINE_EACH_GRADE;
import static lotto.util.ConstantList.MONEY_EACH_GRADE;
import static lotto.util.ConstantList.RESULT_MESSAGE_EACH_GRADE;
import static lotto.util.ConstantMessages.COUNT_TICKET;
import static lotto.util.ConstantMessages.DEPOSIT_TICKET_MONEY;
import static lotto.util.ConstantMessages.INPUT_ANSWER_NUMBER;
import static lotto.util.ConstantMessages.INPUT_BONUS_NUMBER;
import static lotto.util.ConstantMessages.MONEY_FORMAT;
import static lotto.util.ConstantMessages.START_RESULT_OUTPUT;
import static lotto.util.ConstantMessages.TOTAL_RETURN;
import static lotto.util.ConstantMessages.TOTAL_RETURN_FORMAT;
import static lotto.util.ConstantMessages.WINNING_STATISTICS;
import static lotto.util.ConstantNumbers.LOTTO_GRADE_QUANTITY;

import java.text.DecimalFormat;
import lotto.model.LottoResult;

public class OutputView {
    public static void printMessage (String message) {
        System.out.println(message);
    }

    public static void printInputMoney () {
        printMessage(DEPOSIT_TICKET_MONEY.getMessage());
    }

    public static void printInputBonusNumber () {
        printMessage(INPUT_BONUS_NUMBER.getMessage());
    }

    public static void printInputAnswerLotto () {
        printMessage(INPUT_ANSWER_NUMBER.getMessage());
    }

    public static void printTicketQuantity (String message) {
        printMessage(message + COUNT_TICKET.getMessage());
    }

    public static void printLottoResult (LottoResult lottoResult) {
        printMessage(WINNING_STATISTICS.getMessage());
        printMessage(START_RESULT_OUTPUT.getMessage());

        for (int i = 0; i < LOTTO_GRADE_QUANTITY.getConstant(); i++) {
            printEachResult (lottoResult.getValue(i), i);
        }
    }

    private static void printEachResult (Integer value, Integer index) {
        DecimalFormat formatter = new DecimalFormat(MONEY_FORMAT.getMessage());

        System.out.printf(
                RESULT_MESSAGE_EACH_GRADE.getConstant().get(index) + "%n",
                LOTTO_CUT_LINE_EACH_GRADE.getConstant().get(index),
                formatter.format(MONEY_EACH_GRADE.getConstant().get(index)),
                value
        );
    }

    public static void printReturn (Double totalReturn) {
        System.out.printf(
                TOTAL_RETURN.getMessage(),
                String.format(TOTAL_RETURN_FORMAT.getMessage(), totalReturn)
        );
    }
}
