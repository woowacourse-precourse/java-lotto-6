package lotto.model;

import static lotto.config.LottoConfig.LOTTO_VALUE_MIN;
import static lotto.config.LottoConfig.LOTTO_VALUE_MAX;
import static lotto.config.LottoConfig.LOTTO_VALUE_SIZE;
import static lotto.Message.ErrorMessage.LOTTO_RANGE_ERROR_MESSAGE;
import static lotto.Message.ErrorMessage.LOTTO_SIZE_ERROR_MESSAGE;
import static lotto.Message.ErrorMessage.LOTTO_IS_DUPLICATE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(String numbers) {
        List<Integer> convertNumbers = convertFormat(numbers);
        rangeValidate(convertNumbers);
        sizeValidate(convertNumbers);
        isDuplicate(convertNumbers);

        this.numbers = convertNumbers;
    }
    private List<Integer> convertFormat(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private void rangeValidate(List<Integer> convertNumbers) {
        for (Integer number: convertNumbers) {
            if (number < LOTTO_VALUE_MIN.getValue() || number > LOTTO_VALUE_MAX.getValue()) {
                throw new IllegalArgumentException(LOTTO_RANGE_ERROR_MESSAGE.getMessage());
            }
        }
    }

    private void sizeValidate(List<Integer> convertNumbers) {
        if (convertNumbers.size() != LOTTO_VALUE_SIZE.getValue()) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MESSAGE.getMessage());
        }
    }

    private void isDuplicate(List<Integer> convertNumbers) {
        List<Integer> distinctNumbers = convertNumbers.stream()
                .distinct()
                .toList();

        if (distinctNumbers.size() != convertNumbers.size()) {
            throw new IllegalArgumentException(LOTTO_IS_DUPLICATE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
