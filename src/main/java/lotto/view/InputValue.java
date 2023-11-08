package lotto.view;

import lotto.exception.ErrorCode;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputValue {

    private static final String SPACING = " ";
    private static final String EMPTY = "";
    private static final String NUMBER_CHECK_REGEX = "\\d*";
    private static final String SEPARATOR = ",";

    public static int getPurchasePrice() {

        String input = removeInputSpaces();

        emptyValueCheck(input);

        return numberCheck(input);

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

    public static List<Integer> getWinningLottoNumbers() {

        String input = removeInputSpaces();

        emptyValueCheck(input);

        List<Integer> numbers = new ArrayList<>();
        for (String temp : input.split(SEPARATOR)) {
            numbers.add(numberCheck(temp));
        }

        return numbers;
    }

    public static int getBonusNumber() {

        String input = removeInputSpaces();

        emptyValueCheck(input);

        return numberCheck(input);
    }

}
