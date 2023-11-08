package lotto.domain;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto create(String input) {
        List<Integer> numbers = validateLottoNumberFormat(input);
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateDuplicated(numbers);
    }

    // TODO: 추가 기능 구현
    private static List<Integer> validateLottoNumberFormat(String input) {
        String[] stringNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String stringNumber : stringNumbers) {
                numbers.add(Integer.parseInt(stringNumber));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER);
        }
        return numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(this::isLottoNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_LOTTO_NUMBER);
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        List<Integer> distinct = numbers.stream()
                .distinct()
                .toList();
        if (distinct.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_LOTTO_NUMBER);
        }
    }

    private boolean isLottoNumber(int number) {
        return LottoConstant.LOTTO_NUMBER_MIN <= number && number <= LottoConstant.LOTTO_NUMBER_MAX;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        return "[" +
                sortedNumbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")) +
                "]";
    }
}
