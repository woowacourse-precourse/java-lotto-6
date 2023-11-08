package lotto.controller;

import static lotto.constants.ErrorMessage.DUPLICATED_NUMBER_MESSAGE;
import static lotto.constants.ErrorMessage.INVALID_INPUT_LENGTH_FORMAT;
import static lotto.constants.ErrorMessage.INVALID_INPUT_MESSAGE;
import static lotto.constants.ErrorMessage.NUMBER_NOT_IN_RANGE_FORMAT;
import static lotto.constants.Common.DELIMITER;
import static lotto.constants.Common.LOTTO_TICKET_LENGTH;
import static lotto.constants.Common.LOTTO_TICKET_PRICE;
import static lotto.constants.Common.MAXIMUM_LOTTO_NUMBER;
import static lotto.constants.Common.MINIMUM_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InputValidator {
    private static boolean checkNumberNotInRange(int number) {
        return !(MINIMUM_LOTTO_NUMBER <= number && number <= MAXIMUM_LOTTO_NUMBER);
    }

    private static boolean checkInvalidPrice(long price) {
        return price < LOTTO_TICKET_PRICE || price % LOTTO_TICKET_PRICE != 0;
    }

    private static boolean checkContainsDuplicatedNumber(List<Integer> inputSequence) {
        HashSet<Integer> checkDuplicate = new HashSet<>(inputSequence);
        return checkDuplicate.size() != LOTTO_TICKET_LENGTH;
    }

    private static List<Integer> parseRawWinningNumber(String rawInput) {
        List<Integer> parsed = new ArrayList<>();
        for (String rawNumber : rawInput.split(DELIMITER)) {
            parsed.add(Integer.parseInt(rawNumber));
        }
        return parsed;
    }
    public static void validateUserInputWinningNumbers(String rawWinningNumbers) throws IllegalArgumentException {
        List<Integer> winningNumbers = parseRawWinningNumber(rawWinningNumbers);
        if (winningNumbers.size() != LOTTO_TICKET_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_INPUT_LENGTH_FORMAT, LOTTO_TICKET_LENGTH));
        }
        if (checkContainsDuplicatedNumber(winningNumbers)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_MESSAGE);
        }

        for (int winningNumber : winningNumbers) {
            if (checkNumberNotInRange(winningNumber)) {
                throw new IllegalArgumentException(String.format(NUMBER_NOT_IN_RANGE_FORMAT,
                        MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER));
            }
        }
    }

    public static void validateUserInputPrice(String rawPrice) throws IllegalArgumentException {
        long price;
        try {
            price = Long.parseLong(rawPrice);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
        if (checkInvalidPrice(price)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateUserInputBonusNumber(String rawBonusNumber) throws IllegalArgumentException {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(rawBonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
        if (checkNumberNotInRange(bonusNumber)) {
            throw new IllegalArgumentException(String.format(NUMBER_NOT_IN_RANGE_FORMAT,
                    MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER));
        }
    }
}
