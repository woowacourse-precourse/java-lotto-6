package lotto.model;

import static lotto.config.LottoConfig.*;
import static lotto.Message.ErrorMessage.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> winningNumbers;

    public Lotto(String winningNumbers) {
        List<Integer> convertNumbers = convertFormat(winningNumbers);
        rangeValidate(convertNumbers);
        sizeValidate(convertNumbers);
        isDuplicate(convertNumbers);

        this.winningNumbers = convertNumbers;
    }
    private List<Integer> convertFormat(String numbers) throws NumberFormatException{
        return Arrays.stream(numbers.split(","))
                .map(value -> {
                    try {
                        return Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException(VALUE_IS_NOT_CONVERT_INTEGER.getMessage());
                    }
                })
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
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_DUPLICATE.getMessage());
        }
    }

    public List<Integer> getWinningNumbers() {
        return new ArrayList<>(winningNumbers);
    }
}
