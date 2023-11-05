package lotto.model;

import static lotto.enumerate.ErrorCode.BONUS_NUMBER_IS_NOT_INTEGER;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_BONUS_DUPLICATE;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_UNDER_OR_OVER;
import static lotto.enumerate.ErrorCode.WINNING_NUMBER_IS_NOT_INTEGER;
import static lotto.util.ExceptionCodeThrow.exceptionCodeThrow;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.record.LottoNumberRecord;

public class WinningNumber {
    private static final String REPLACE_TARGET = " ";
    private static final String REPLACE_REPLACEMENT = "";
    private static final String SPLIT_REGEX = ",";
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(String numbers, String bonusNumber) {
        List<Integer> convertedNumbers = convert(numbers);
        int convertedBonusNumber = convertBonus(bonusNumber);

        validateBonusNumber(convertedNumbers, convertedBonusNumber);
        this.numbers = convertedNumbers;
        this.bonusNumber = convertedBonusNumber;
    }

    private static int convertBonus(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            exceptionCodeThrow(BONUS_NUMBER_IS_NOT_INTEGER);
        }
        return 0;
    }

    private static String[] getSplit(String numbers) {
        return numbers.replace(REPLACE_TARGET, REPLACE_REPLACEMENT).split(SPLIT_REGEX);
    }

    private List<Integer> convert(String numbers) {
        numberValid(numbers);
        return Arrays.stream(getSplit(numbers)).mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList());
    }

    private void numberValid(String numbers) {
        if (Arrays.stream(getSplit(numbers)).anyMatch(this::notInt)) {
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
            matches = getMatches(number, matches);
        }
        return matches;
    }

    private int getMatches(int number, int matches) {
        if (numbers.contains(number)) {
            matches++;
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
        if (bonusNumber < LOTTO_START_NUMBER || bonusNumber > LOTTO_END_NUMBER) {
            exceptionCodeThrow(LOTTO_NUMBER_UNDER_OR_OVER);
        }
    }

    private void bonusNumberWinningNumberDuplicateValidate(List<Integer> numbers, int bonusNumber) {
        if (numbers.stream().anyMatch(number -> number == bonusNumber)) {
            exceptionCodeThrow(LOTTO_NUMBER_BONUS_DUPLICATE);
        }
    }
}
