package lotto.validator;

import lotto.constant.LottoConstants;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NumberValidator {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void validateLottoDuplication(List<Integer> numbers) {
        List<Integer> collect = numbers.stream().distinct()
                .collect(Collectors.toList());

        if (collect.size() != LottoConstants.LOTTO_SIZE) {
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void validateLottoNumberRange(List<Integer> numbers) {
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);

        if (max.get() > LottoConstants.LOTTO_MAX_NUMBER || min.get() < LottoConstants.LOTTO_MIN_NUMBER) {
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
