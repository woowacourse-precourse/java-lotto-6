package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.ErrorMessage.NOT_LIST;
import static lotto.view.ErrorMessage.NOT_NUMBER;

public class InputView {
    // 구입가격 입력관련
    public static String inputLongData() {
        String input = readLine();
        validateParseLong(input);
        return input;
    }

    private static void validateParseLong(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    // 당첨 번호 입력 관련
    public static String inputIntegerListData() {
        String input = readLine();
        validateConvertIntegerList(input);
        return input;
    }

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
            try {
                Integer.parseInt(element);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NOT_LIST.getMessage());
            }
        }
    }

    // 보너스 번호 입력관련
    public static String inputIntegerData() {
        String input = readLine();
        validateParseInteger(input);
        return input;
    }

    private static void validateParseInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }
}
