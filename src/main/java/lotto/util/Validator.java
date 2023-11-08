package lotto.util;

import lotto.config.ErrorMessage;
import lotto.config.LottoConfig;
import lotto.dto.request.BonusNumberDto;
import lotto.dto.request.WinningNumbersDto;

import java.util.HashSet;
import java.util.List;

public class Validator {

    public static int validateAndParseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER_INPUT.getMessage());
        }
    }

    public static void validateNotNull(Object value) {
        if (value == null) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_PRESENT.getMessage());
        }
    }

    public static void validateNumberInRange(int number) {
        if (number < LottoConfig.START_OF_LOTTO_NUMBER.getValue()
                || number > LottoConfig.END_OF_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(
                    ErrorMessage.NUMBER_RANGE_ERROR.getFormattedMessage(
                            LottoConfig.START_OF_LOTTO_NUMBER.getValue(),
                            LottoConfig.END_OF_LOTTO_NUMBER.getValue()
                    ));
        }
    }

    public static void validateNumbersInRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(num -> num >= LottoConfig.START_OF_LOTTO_NUMBER.getValue()
                && num <= LottoConfig.END_OF_LOTTO_NUMBER.getValue())) {
            throw new IllegalArgumentException(
                    ErrorMessage.NUMBER_RANGE_ERROR.getFormattedMessage(
                            LottoConfig.START_OF_LOTTO_NUMBER.getValue(),
                            LottoConfig.END_OF_LOTTO_NUMBER.getValue()
                    ));
        }
    }

    public static void validateUniqueNumbers(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public static void validateWinningNumbers(WinningNumbersDto winningNumbersDto) {
        List<Integer> winningNumbers = winningNumbersDto.getNumbers();
        validateWinningNumbers(winningNumbers);
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        validateNotNull(winningNumbers);

        if (winningNumbers.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.MISSING_WINNING_NUMBERS.getMessage());
        }
        validateNumbersSize(winningNumbers, LottoConfig.LOTTO_NUMBER_COUNT.getValue());
        validateUniqueNumbers(winningNumbers);
        validateNumbersInRange(winningNumbers);
    }

    public static void validateBonusNumber(WinningNumbersDto winningNumbersDto, BonusNumberDto bonusNumberDto) {
        List<Integer> winningNumbers = winningNumbersDto.getNumbers();
        int bonusNumber = bonusNumberDto.getBonus();
        validateBonusNumber(winningNumbers,bonusNumber);
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateNotNull(bonusNumber);
        validateNumberInRange(bonusNumber);

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATION.getMessage());
        }
    }

    public static void validateNumbersSize(List<Integer> numbers, int size) {
        if (numbers.size() != size) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_SIZE_ERROR.getFormattedMessage(size));
        }
    }
}
