package lotto.validation;

import java.util.List;

public final class Validation {
    //    private static final String ONLY_NUMBER_REGEX = "[0-9]+";
    private static final int MINIMUM_AMOUNT = 1000;
    private static final int TARGET_LEFTOVER = 0;
    private static final int LOTTO_LIST_SIZE = 6;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final String BLANK_ERROR = "[ERROR] 빈 값은 입력할 수 없습니다.";
    private static final String NON_NUMBER_ERROR = "[ERROR] 숫자를 제외한 값은 입력할 수 없습니다.";
    private static final String DIGIT_ERROR = "[ERROR] 금액은 1,000원 단위로 입력해야 합니다.";
    private static final String OUT_OF_RANGE_ERROR = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String NUMBER_OVERLAP_ERROR = "[ERROR] 당첨 번호와 중복되는 번호는 입력할 수 없습니다.";
    private static final String DUPLICATE_NUMBER_ERROR = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private static final String LOTTO_LIST_SIZE_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";


    public static void validateStringToInteger(String string) {
        if (!string.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NON_NUMBER_ERROR);
        }
    }

    public static void validateStringArrayToIntegerList(String[] stringArray) {
        for (String string : stringArray) {
            validateStringToInteger(string);
        }
    }

    public static void validateIsBlank(String string) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR);
        }
    }

    public static void validateDigit(int number) {
        if (number % MINIMUM_AMOUNT != TARGET_LEFTOVER) {
            throw new IllegalArgumentException(DIGIT_ERROR);
        }
    }

    public static void validateListOutOfRangeNumber(List<Integer> numbers) {
        for (int number : numbers) {
            validateOutOfRangeNumber(number);
        }
    }

    public static void validateOutOfRangeNumber(int number) {
        if (number < MINIMUM_LOTTO_NUMBER || MAXIMUM_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR);
        }
    }

    public static void validateDuplicateNumber(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount < numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }

    public static void validateListSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LIST_SIZE) {
            throw new IllegalArgumentException(LOTTO_LIST_SIZE_ERROR);
        }
    }

    public static void validateListContainsNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(NUMBER_OVERLAP_ERROR);
        }
    }
}
