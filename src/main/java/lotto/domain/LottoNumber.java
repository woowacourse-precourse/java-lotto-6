package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.service.LottoGeneratorService;
import lotto.view.ErrorMessage;

public class LottoNumber {

    private static final String COMMA = ",";
    private static final String EMPTY = "";

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void drawWiningNumbers(String value) {
        checkWinningNumbers(value);
        winningNumbers = toListInteger(value);
    }

    public void drawBonusNumber(String value) {
        checkBonusNumber(value);
        bonusNumber = Integer.parseInt(value);
    }

    private void checkWinningNumbers(String value) {
        validateEmpty(value);
        validateOnlyNumberAndComma(value);
        validateValueExists(value);
        List<Integer> numbers = toListInteger(value);
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void checkBonusNumber(String value) {
        validateEmpty(value);
        validateOnlyNumber(value);
        validateRangeOfBonus(value);
        validateDuplicateWinningNumbers(value);
    }

    private List<Integer> toListInteger(String value) {
        List<String> values = Arrays.asList(value.split(COMMA));
        List<Integer> numbers = values.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        return numbers;
    }

    private void validateEmpty(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY);
        }
    }

    private void validateOnlyNumberAndComma(String value) {
        String removeComma = value.replace(COMMA,EMPTY);
        try {
            Long.parseLong(removeComma);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER_ADN_COMMA);
        }
    }

    private void validateValueExists(String value) {
        List<String> numbers = Arrays.asList(value.split(COMMA));
        for (String number : numbers) {
            if (number.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.VALUE_EXISTS);
            }
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoGeneratorService.MAX_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.WINING_NUMBER_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LottoGeneratorService.MAX_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.WINING_NUMBER_DUPLICATE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().filter(n -> (n >= LottoGeneratorService.MIN_LOTTO_NUMBER) &&
                (n <= LottoGeneratorService.MAX_LOTTO_NUMBER)).count() != LottoGeneratorService.MAX_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.WINING_NUMBER_RANGE);
        }
    }

    private void validateOnlyNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER);
        }
    }

    private void validateRangeOfBonus(String value) {
        int number = Integer.parseInt(value);
        if ((number < LottoGeneratorService.MIN_LOTTO_NUMBER) || (number > LottoGeneratorService.MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE);
        }
    }

    private void validateDuplicateWinningNumbers(String value) {
        int number = Integer.parseInt(value);
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber == number) {
                throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE);
            }
        }
    }
}
