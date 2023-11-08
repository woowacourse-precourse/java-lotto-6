package lotto.model;

import java.util.*;

import static lotto.util.Constants.*;

public class Jackpot {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Jackpot(String inputWinningNumbers, String inputBonusNumber) {
        String[] splitWinningNumbers = getSplitWinningNumbers(inputWinningNumbers);

        List<Integer> winningNumbers = new ArrayList<>();
        validateWinningNumbers(splitWinningNumbers, winningNumbers);
        this.winningNumbers = winningNumbers;

        validateBonusNumber(inputBonusNumber, splitWinningNumbers);
        this.bonusNumber = Integer.parseInt(inputBonusNumber);
    }

    private static void validateBonusNumber(String inputBonusNumber, String[] splitWinningNumbers) {
        validateNumeric(inputBonusNumber);
        validateDuplicateBonusNumber(splitWinningNumbers, inputBonusNumber);
        checkNumberInRange(Integer.parseInt(inputBonusNumber));
    }

    private static void validateWinningNumbers(String[] splitWinningNumbers, List<Integer> winningNumbers) {
        validateDuplicateNumbers(splitWinningNumbers);
        addWinningNumber(splitWinningNumbers, winningNumbers);
        validateNumberInRange(winningNumbers);
    }

    private static String[] getSplitWinningNumbers(String inputWinningNumbers) {
        String[] splitWinningNumbers = inputWinningNumbers.split(",");
        validateWinningNumbersSize(splitWinningNumbers);
        return splitWinningNumbers;
    }

    private static void addWinningNumber(String[] splitWinningNumbers, List<Integer> winningNumbers) {
        for (String number : splitWinningNumbers) {
            validateNumeric(number);
            winningNumbers.add(Integer.parseInt(number));
        }
    }

    private static void validateNumeric(String bonusNumber) {
        if (!bonusNumber.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_WINNING_NUMBERS_NUMERIC);
        }
    }

    private static void validateWinningNumbersSize(String[] splitWinningNumbers) {
        if (splitWinningNumbers.length != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_SIX_NUMBERS);
        }
    }

    private static void validateDuplicateNumbers(String[] splitWinningNumbers) {
        List<String> winningNumbers = Arrays.asList(splitWinningNumbers);
        Set<String> uniqueWinningNumbers = new HashSet<>(winningNumbers);
        if (winningNumbers.size() != uniqueWinningNumbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_NUMBERS);
        }
    }

    private static void validateDuplicateBonusNumber(String[] splitWinningNumbers, String bonusNumber) {
        for (String winningNumber : splitWinningNumbers) {
            if (winningNumber.equals(bonusNumber)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_NOT_CONTAINS_BONUS_NUMBER);
            }
        }
    }

    private static void validateNumberInRange(List<Integer> numbers) {
        for (int number : numbers) {
            checkNumberInRange(number);
        }
    }

    private static void checkNumberInRange(int number) {
        if (number < LOTTERY_NUMBER_MIN || number > LOTTERY_NUMBER_MAX) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_IN_RANGE);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}