package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.validator.LottoWinningNumberValidator;

public class Lotto {
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final String VALUE_OUT_OF_RANGE_MESSAGE = "[ERROR] " + MIN_LOTTO_NUMBER + "와 " + MAX_LOTTO_NUMBER +  " 사이의 값을 입력하시오.";
    public static final String DUPLICATE_LOTTO_NUMBERS_MESSAGE = "[ERROR] 중복된 번호가 있습니다.";
    public static final String LOTTO_NUMBERS_LENGTH_INVALID_MESSAGE = "[ERROR] 6개의 번호를 입력하시오. ";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateValueInRange(numbers);
        this.numbers = numbers;
    }

    public static List<Integer> createRank() {
        List<Integer> rank = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));
        return rank;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_LENGTH_INVALID_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<String> uniqueNumbers = new HashSet<>();
        for (int winningNumber : numbers) {
            if (!uniqueNumbers.add(String.valueOf(winningNumber))) {
                throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBERS_MESSAGE);
            }
        }
    }

    public static void validateValueInRange(List<Integer> WinningNumbers) {
        for (Integer number : WinningNumbers) {
            int num = Integer.parseInt(String.valueOf(number));
            if (num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(VALUE_OUT_OF_RANGE_MESSAGE);
            }
        }
    }
}
