package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.exception.IllegalInputException;

public class ValidationImpl implements Validation {
    private final String DELIMITER = ",";
    private final int NUMBER_START = 1;
    private final int NUMBER_END = 45;
    private final int NUMBER_COUNT = 6;
    private final Pattern WINNING_NUMBER_PATTERN = Pattern.compile("[^,\\d]");
    private final Pattern DIGITS_PATTERN = Pattern.compile("\\D");

    @Override
    public boolean isValidWinningNumbers(String input) {
        int numberCount = 0;
        hasSpecialCharExceptCommaDigits(input);
        String[] strings = input.split(DELIMITER);
        for (String string : strings) {
            existDigitBetweenComma(string);
            isBetween(Integer.parseInt(string));
            numberCount++;
        }
        isDistinctNumbers(input);
        isEqualToWinningNumberCount(numberCount);
        return true;
    }

    private void isEqualToWinningNumberCount(int numberCount) {
        if (numberCount != NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력해주세요.");
        }
    }

    private void hasSpecialCharExceptCommaDigits(String input) throws IllegalArgumentException {
        if (WINNING_NUMBER_PATTERN.matcher(input).find()) {
            throw new IllegalArgumentException("[ERROR] 오직 숫자와 쉼표만 입력 가능합니다.");
        }
    }

    private void existDigitBetweenComma(String stringDigit) throws IllegalArgumentException {
        if (stringDigit.length() < 1) {
            throw new IllegalArgumentException("[ERROR] 쉼표 사이에 숫자를 입력해주세요.");
        }
    }

    private void isDistinctNumbers(String input) throws IllegalArgumentException {
        String[] strings = input.split(",");
        Set<Integer> distinctNumbers = new HashSet<>();
        for (String string : strings) {
            distinctNumbers.add(Integer.parseInt(string));
        }
        if (distinctNumbers.size() < strings.length) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private void isBetween(int number) throws IllegalArgumentException {
        if (number < NUMBER_START || number > NUMBER_END) {
            throw new IllegalArgumentException("[ERROR] 번호의 범위는 1 ~ 45 사이 입니다.");
        }
    }

    @Override
    public boolean isValidBonusNumber(String input, List<Integer> winningNumbers) {
        hasAllCharExceptDigits(input);
        isBetween(Integer.parseInt(input));
        isDuplicatedInput(input, winningNumbers);
        return true;
    }

    private void hasAllCharExceptDigits(String input) throws IllegalArgumentException {
        if (DIGITS_PATTERN.matcher(input).find()) {
            throw new IllegalArgumentException("[ERROR] 오직 숫자만 입력 가능합니다.");
        }
    }

    private void isDuplicatedInput(String input, List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자가 이미 있습니다.");
        }
    }

    @Override
    public boolean isValidMoney(String input) {
        hasAllCharExceptDigits(input);
        return true;
    }
}
