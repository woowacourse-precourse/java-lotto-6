package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public int getUserAmount() {
        String userInput = Console.readLine();
        validateUserInput(userInput);
        return Integer.parseInt(userInput);
    }

    private void validateUserInput(String userInput) {
        validateOnlyNumber(userInput);
        validateAboveOrEqualThousand(userInput);
        validateDivisibleByThousand(userInput);
    }

    private void validateOnlyNumber(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if(!Character.isDigit(userInput.charAt(i))){
                throw new IllegalArgumentException(Constants.ONLY_NUMBER_MESSAGE);
            }
        }
    }

    private void validateAboveOrEqualThousand(String userInput) {
        if (Integer.parseInt(userInput) < Constants.LOTTO_PRICE) {
            throw new IllegalArgumentException(Constants.ABOVE_THOUSAND_MESSAGE);
        }
    }

    private void validateDivisibleByThousand(String userInput) {
        if ((Integer.parseInt(userInput) % Constants.LOTTO_PRICE) != Constants.ZERO_CHANGE) {
            throw new IllegalArgumentException(Constants.DIVISIBLE_BY_THOUSAND_MESSAGE);
        }
    }

    public List<Integer> getWinningNumbers() {
        List<String> userInput = Arrays.asList(Console.readLine().split(Constants.COMMA));
        validateWinningNumbers(userInput);

        return userInput.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateWinningNumbers(List<String> userInput) {
        validateNoBlank(userInput);
        validateOnlyNumbers(userInput);
        validateNumbersSizeSix(userInput);
        validateNumberRange(userInput);
        validateDuplicatedNumber(userInput);
    }

    private void validateNoBlank(List<String> userInput) {
        if (userInput.stream().anyMatch(num -> num.contains(Constants.BLANK))) {
            throw new IllegalArgumentException(Constants.NO_BLANK_MESSAGE);
        }
    }

    private void validateOnlyNumbers(List<String> userInput) {
        for (String num : userInput) {
            if(!(num.chars().allMatch(Character::isDigit))) {
                throw new IllegalArgumentException(Constants.ONLY_NUMBERS_MESSAGE);
            }
        }
    }

    private void validateNumbersSizeSix(List<String> userInput) {
        if (userInput.size() != Constants.LOTTO_NUMBERS) {
            throw new IllegalArgumentException(Constants.SIX_NUMBERS_MESSAGE);
        }
    }

    private void validateNumberRange(List<String> userInput) {
        if (userInput.stream()
                .mapToInt(Integer::parseInt)
                .anyMatch(num -> num < Constants.LOTTO_MIN_NUM || num > Constants.LOTTO_MAX_NUM)) {
            throw new IllegalArgumentException(Constants.NUMBER_RANGE_MESSAGE);
        }
    }

    private void validateDuplicatedNumber(List<String> userInput) {
        if (userInput.size() != userInput.stream().distinct().count()) {
            throw new IllegalArgumentException(Constants.UNIQUE_SIX_NUMBERS_MESSAGE);
        }
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        String userInput = Console.readLine();
        validateBonusNumber(userInput, winningNumbers);
        return Integer.parseInt(userInput);
    }

    private void validateBonusNumber(String userInput, List<Integer> winningNumbers) {
        validateOnlyOneNumber(userInput);
        validateBonusNumberRange(userInput);
        validateDuplicateWithWinningNumbers(userInput, winningNumbers);
    }

    private void validateOnlyOneNumber(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if(!Character.isDigit(userInput.charAt(i))){
                throw new IllegalArgumentException(Constants.ONLY_ONE_NUMBER_MESSAGE);
            }
        }
    }

    private void validateBonusNumberRange(String userInput) {
        int bonusNumber = Integer.parseInt(userInput);
        if (!(bonusNumber >= Constants.LOTTO_MIN_NUM && bonusNumber <= Constants.LOTTO_MAX_NUM)) {
            throw new IllegalArgumentException(Constants.BONUS_NUM_RANGE_MESSAGE);
        }
    }

    private void validateDuplicateWithWinningNumbers(String userInput, List<Integer> winningNumbers) {
        int bonusNumber = Integer.parseInt(userInput);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Constants.BONUS_NUM_DUPLICATE_MESSAGE);
        }
    }
}
