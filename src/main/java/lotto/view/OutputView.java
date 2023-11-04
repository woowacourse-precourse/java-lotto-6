package lotto.view;

import static java.lang.String.format;
import static lotto.util.ConstantList.LOTTO_QUANTITY_EACH_GRADE;
import static lotto.util.ConstantList.MONEY_EACH_GRADE;
import static lotto.util.ConstantList.RESULT_MESSAGE_EACH_GRADE;
import static lotto.util.ConstantMessages.BONUS_RESULT_MESSAGE;
import static lotto.util.ConstantMessages.NONE_BONUS_RESULT_MESSAGE;
import static lotto.util.ConstantMessages.START_RESULT_OUTPUT;
import static lotto.util.ConstantMessages.WINNING_STATISTICS;
import static lotto.util.ConstantNumbers.LOTTO_FIFTH_MONEY;
import static lotto.util.ConstantNumbers.LOTTO_FIFTH_QUANTITY;
import static lotto.util.ConstantNumbers.LOTTO_FIRST_MONEY;
import static lotto.util.ConstantNumbers.LOTTO_FIRST_QUANTITY;
import static lotto.util.ConstantNumbers.LOTTO_FOURTH_MONEY;
import static lotto.util.ConstantNumbers.LOTTO_FOURTH_QUANTITY;
import static lotto.util.ConstantNumbers.LOTTO_GRADE_QUANTITY;
import static lotto.util.ConstantNumbers.LOTTO_SECOND_MONEY;
import static lotto.util.ConstantNumbers.LOTTO_SECOND_QUANTITY;
import static lotto.util.ConstantNumbers.LOTTO_THIRD_MONEY;
import static lotto.util.ConstantNumbers.RESET_INTEGER_ONE;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import lotto.model.LottoResult;

public class OutputView {
    public static void printMessage (String message) {
        System.out.println(message);
    }

    public static void printLottoResult (LottoResult lottoResult) {
        System.out.println(WINNING_STATISTICS.getMessage());
        System.out.println(START_RESULT_OUTPUT.getMessage());

        for (int i = RESET_INTEGER_ONE.getConstant();
             i <= LOTTO_GRADE_QUANTITY.getConstant(); i++) {
            printEachResult (lottoResult.getValue(i), i);
        }
    }

    private static void printEachResult (Integer value, Integer index) {
        DecimalFormat formatter = new DecimalFormat("###,###원");

        System.out.printf(RESULT_MESSAGE_EACH_GRADE.getConstant().get(index) + "%n",
                LOTTO_QUANTITY_EACH_GRADE.getConstant().get(index),
                formatter.format(MONEY_EACH_GRADE.getConstant().get(index)),
                value);
    }
}
