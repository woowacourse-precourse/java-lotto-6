package lotto.view;

import lotto.exception.ErrorCode;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputValue {

    private static final String SPACING = " ";
    private static final String EMPTY = "";
    private static final String NUMBER_CHECK_REGEX = "\\d*";
    private static final Integer ZERO = 0;
    private static final Integer PRICE_UNIT = 1000;
    private static final String SEPARATOR = ",";

    private static final Integer START_NUMBER = 1;

    private static final Integer END_NUMBER = 45;

    public static int getPurchasePrice() {

        String input = removeInputSpaces();

        emptyValueCheck(input);

        int price = numberCheck(input);

        priceUnitCheck(price);

        return price;
    }

    private static String removeInputSpaces() {
        return readLine().replaceAll(SPACING, EMPTY);
    }

    private static void emptyValueCheck(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.EMPTY_VALUE.getMessage());
        }
    }

    private static int numberCheck(String input) {

        if (!input.matches(NUMBER_CHECK_REGEX)) {
            throw new IllegalArgumentException(ErrorCode.NOT_NUMBER.getMessage());
        }

        return Integer.parseInt(input);
    }

    private static void priceUnitCheck(int price) {
        if (price % PRICE_UNIT != ZERO) {
            throw new IllegalArgumentException(ErrorCode.INCORRECT_UNIT.getMessage());
        }
    }

    public static List<Integer> getWinLottoNumbers() {

        String input = removeInputSpaces();

        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split(SEPARATOR))
            numbers.add(numberCheck(number));

        return numbers;
    }

    public static int getBonusNumber() {

        String input = removeInputSpaces();

        int bonusNumber = numberCheck(input);

        validateBonusNumber(bonusNumber);

        return bonusNumber;
    }

    private static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber > END_NUMBER || bonusNumber < START_NUMBER) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER_RANGE.getMessage());
        }
    }

}
