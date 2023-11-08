package lotto.model;

import java.util.*;

public class Jackpot {
    public static final String NUMBER_PATTERN = "\\d+";
    public static final String ERROR_MESSAGE_WINNING_NUMBERS_NUMERIC = "[ERROR] 당첨 번호는 숫자로만 이루어져야 합니다.";
    public static final String ERROR_MESSAGE_NOT_SIX_NUMBERS = "[ERROR] 당첨 번호는 6개로 이루어져야 합니다.";
    public static final String ERROR_MESSAGE_DUPLICATE_NUMBERS = "[ERROR] 당첨번호에 중복된 숫자가 들어갈 수 없습니다.";
    public static final String ERROR_MESSAGE_NOT_CONTAINS_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String ERROR_MESSAGE_NUMBER_IN_RANGE = "[ERROR] 당첨 번호/보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.";

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
        if (splitWinningNumbers.length != 6) {
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
        if (number < 1 || number > 45) {
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