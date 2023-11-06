package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        removeDuplication(numbers);
        checkSizeOfLotto(numbers);
        numbers.stream().forEach(number -> checkRangeOfLottoNumber(number));
    }

    private static void removeDuplication(List<Integer> numbers) {
        numbers.stream().distinct().collect(Collectors.toList());
    }

    private static void checkSizeOfLotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.OVER_SIZE_OF_LOTTO);
        }
    }

    private static void checkRangeOfLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_ERROR);
        }
    }



}
