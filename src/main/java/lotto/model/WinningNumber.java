package lotto.model;

import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_BONUS_DUPLICATE;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_UNDER_OR_OVER;
import static lotto.enumerate.ErrorCode.WINNING_NUMBER_IS_NOT_INTEGER;
import static lotto.util.ExceptionCodeThrow.exceptionCodeThrow;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.record.LottoNumberRecord;

public class WinningNumber {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(String numbers, String bonusNumber) {
        List<Integer> convertedNumbers = convert(numbers);
        int convertedBonusNumber = Integer.parseInt(bonusNumber);
        validateBonusNumber(convertedNumbers, convertedBonusNumber);
        this.numbers = convertedNumbers;
        this.bonusNumber = convertedBonusNumber;
    }

    private List<Integer> convert(String numbers) {
        numberValid(numbers);
        return Arrays.stream(numbers
                        .replace(" ", "")
                        .split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private void numberValid(String numbers) {
        if (Arrays.stream(numbers.split(",")).anyMatch(this::notInt)) {
            exceptionCodeThrow(WINNING_NUMBER_IS_NOT_INTEGER);
        }
    }

    private boolean notInt(String number) {
        try {
            Integer.parseInt(number);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public int countMatchingNumbers(LottoNumberRecord lottoNumberRecord) {
        int matches = 0;
        for (int number : lottoNumberRecord.numbers()) {
            if (numbers.contains(number)) {
                matches++;
            }
        }
        return matches;
    }

    public boolean hasMatchingBonusNumber(LottoNumberRecord lottoNumberRecord) {
        return lottoNumberRecord.numbers().contains(bonusNumber);
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        bonusNumberWinningNumberDuplicateValidate(numbers, bonusNumber);
        bonusNumberUnderOverValidate(bonusNumber);
    }

    private void bonusNumberUnderOverValidate(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            exceptionCodeThrow(LOTTO_NUMBER_UNDER_OR_OVER);
        }
    }

    private void bonusNumberWinningNumberDuplicateValidate(List<Integer> numbers, int bonusNumber) {
        if (numbers.stream().anyMatch(number -> number == bonusNumber)) {
            exceptionCodeThrow(LOTTO_NUMBER_BONUS_DUPLICATE);
        }
    }
}
