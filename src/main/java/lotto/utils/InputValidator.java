package lotto.utils;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    private static final String ERROR = "[ERROR] ";
    private static final String NOT_NUMBER = "숫자를 입력해주세요.";
    private static final String BLANK = "입력이 공백입니다.";
    private static final String INVALID_PRICE = "1000원 단위의 수를 입력해주세요.";
    private static final String INVALID_SIZE = "6개의 번호를 입력해주세요.";
    private static final String INVALID_RANGE = "1부터 45까지의 번호만 입력해주세요.";
    private static final String DUPLICATED = "중복된 숫자가 존재합니다.";
    private static final String INVALID_LOTTO_FORMAT = "숫자와 쉼표를 이용해 입력해주세요.";

    private static final int PRICE = 1000;
    private static final int SIZE = 6;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;

    private static final Pattern NOT_NUMBER_PATTERN = Pattern.compile("^[1-9]*$");
    private static final Pattern INVALID_LOTTO_PATTERN = Pattern.compile("(\\d*,){5}\\d*$");

    public static void checkIsNumber(String input) {
        if (!NOT_NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ERROR + NOT_NUMBER);
        }
    }

    public static void checkIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR + BLANK);
        }
    }

    public static void checkPrice(String input) {
        if (Integer.parseInt(input) % PRICE != 0) {
            throw new IllegalArgumentException(ERROR + INVALID_PRICE);
        }
    }

    public static void checkRange(String input) {
        int number = Integer.parseInt(input);
        if (number < MIN_NUM || number > MAX_NUM) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    public static void checkLottoSizeIsSix(List<Integer> input) {
        if (input.size() != SIZE) {
            throw new IllegalArgumentException(ERROR + INVALID_SIZE);
        }
    }

    public static void checkLottoIsInRange(List<Integer> input) {
        if (input.stream().anyMatch(number -> number < MIN_NUM || number > MAX_NUM)) {
            throw new IllegalArgumentException(ERROR + INVALID_RANGE);
        }
    }

    public static void checkLottoNumberIsDuplicated(List<Integer> input) {
        if (input.stream().distinct().findAny().isEmpty()) {
            throw new IllegalArgumentException(ERROR + DUPLICATED);
        }
    }

    public static void checkLottoNumberFormat(String input) {
        if (!INVALID_LOTTO_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ERROR + INVALID_LOTTO_FORMAT);
        }
    }

}
