package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.NumericValidator;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private static final String NUMBER_SPLIT_DELIMITER = ",";

    // 기본 생성자가 만들어지는 것을 막는다. (인스턴스화 방지용).
    private InputView() {
        throw new AssertionError();
    }

    public static long readPurChaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return readLongNumber();
    }

    private static long readLongNumber() {
        final String strNumber = readLine();
        validateNumeric(strNumber);
        return Long.parseLong(strNumber);
    }

    private static String readLine() {
        return Console.readLine();
    }

    private static void validateNumeric(final String... strNumbers) {
        for (final String strNumber : strNumbers) {
            NumericValidator.validate(strNumber);
        }
    }
}
