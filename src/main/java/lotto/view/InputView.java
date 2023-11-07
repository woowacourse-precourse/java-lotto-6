package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.model.SystemConstant.DataType.INTEGER;
import static lotto.model.SystemConstant.DataType.INTEGER_LIST;
import static lotto.model.SystemConstant.DataType.LONG;
import static lotto.view.ErrorMessage.NOT_LIST;
import static lotto.view.ErrorMessage.NOT_NUMBER;

import lotto.model.SystemConstant.DataType;

public class InputView {
    public static String inputData(DataType type) {
        String input = readLine();
        validateData(input, type);
        return input;
    }

    private static void validateData(String input, DataType type) {
        if (type == INTEGER || type == LONG) {
            validateParseNumber(input, type);
        }
        if (type == INTEGER_LIST) {
            validateConvertIntegerList(input);
        }
    }

    // 구매 금액, 보너스 관련
    private static void validateParseNumber(String input, DataType type) {
        try {
            convertStringToNumber(input, type);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    private static void convertStringToNumber(String input, DataType type) {
        if (type == INTEGER) {
            Integer.parseInt(input);
        }
        if (type == LONG) {
            Long.parseLong(input);
        }
    }

    // 당첨 번호 입력 관련

    private static void validateConvertIntegerList(String input) {
        validateFormat(input);
        validateElementIsInteger(input);
    }

    private static void validateFormat(String input) {
        if (input.charAt(0) == ',' || input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException(NOT_LIST.getMessage());
        }
    }

    private static void validateElementIsInteger(String input) {
        for (String element : input.split(",")) {
            validateParseNumber(element, INTEGER);
        }
    }
}
