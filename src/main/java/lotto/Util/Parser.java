package lotto.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static final String NULL_EMPTY_MESSAGE = "[ERROR] 값을 입력해주세요";
    public static final String INVALID_FORM_MESSAGE = "[ERROR] 쉼표로 구분된 6개의 숫자를 입력해주세요";
    public static final String INVALID_RANGE_MESSAGE = "[ERROR] 1~45 사이의 숫자를 입력해주세요";
    public static final String DUPLICATE_MESSAGE = "[ERROR] 로또 번호에 중복된 값이 있습니다.";
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public static List<Integer> convertStringToNumbers(String winningNumber)
        throws IllegalArgumentException {
        validateWinningNum(winningNumber);
        List<Integer> winningNumbers = new ArrayList<>();
        String[] numbers = winningNumber.split(",");
        Arrays.stream(numbers)
            .forEach(number -> winningNumbers.add(Integer.parseInt(number)));
        return winningNumbers;
    }

    private static void validateWinningNum(String winningNumber) throws IllegalArgumentException {
        validateNullOrEmpty(winningNumber);
        validateForm(winningNumber);
        validateUnique(winningNumber);
        validateNumberRange(winningNumber);
    }

    private static void validateNumberRange(String winningNumber) throws IllegalArgumentException {
        String[] numbers = winningNumber.split(",");
        int[] winNumbers = Arrays.stream(numbers)
            .mapToInt(Integer::parseInt)
            .toArray();
        for (int number : winNumbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
            }
        }
    }

    private static void validateForm(String winningNumber) throws IllegalArgumentException {
        String regex = "\\d+,\\d+,\\d+,\\d+,\\d+,\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(winningNumber);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_FORM_MESSAGE);
        }
    }

    private static void validateUnique(String winningNumber) throws IllegalArgumentException {
        String[] numbers = winningNumber.split(",");
        Set<Integer> uniqueNumbers = new HashSet<>();
        boolean hasDuplicate = Arrays.stream(numbers)
            .map(Integer::parseInt)
            .anyMatch(num -> !uniqueNumbers.add(num));
        if (hasDuplicate) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }

    private static void validateNullOrEmpty(String winningNumber) throws IllegalArgumentException {
        if (winningNumber == null || winningNumber.equals("")) {
            throw new IllegalArgumentException(NULL_EMPTY_MESSAGE);
        }
    }
}
