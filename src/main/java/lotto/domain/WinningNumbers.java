package lotto.domain;

import static lotto.constant.LottoInformation.MAX_NUMBER;
import static lotto.constant.LottoInformation.MIN_NUMBER;
import static lotto.constant.message.ErrorMessage.DUPLICATE_BONUS;
import static lotto.constant.message.ErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.constant.message.ErrorMessage.NOT_ONLY_DIGIT;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningNumbers {
    private Lotto winningNumber;
    private int bonusNumber;

    public void makeWinningNumber(String input) {
        List<Integer> winningNumbers = convertToWinningNumber(input);
        this.winningNumber = new Lotto(winningNumbers);
    }

    private List<Integer> convertToWinningNumber(String input) {
        String[] numbers = input.split(",");
        Pattern pattern = Pattern.compile("^[0-9]+$");
        boolean result = Arrays.stream(numbers)
                .allMatch((number) -> pattern.matcher(number).matches());

        if (!result) {
            throw new IllegalArgumentException(NOT_ONLY_DIGIT.getMessage());
        }
        return Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
    }

    public void makeBonusNumber(int bonusNumber) throws IllegalArgumentException {
        validateBonusNumberRange(bonusNumber);
        validateDuplicateBonus(winningNumber, bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (!validRange(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private int convertToBonusNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_ONLY_DIGIT.getMessage());
        }
        return Integer.parseInt(input);
    }

    private boolean validRange(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    private void validateDuplicateBonus(Lotto winningNumber, int bonusNumber) {
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS.getMessage());
        }
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
