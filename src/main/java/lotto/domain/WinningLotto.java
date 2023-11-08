package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.constant.ExceptionMessage.*;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNum;

    private WinningLotto(Lotto lotto, int bonusNum) {
        this.lotto = lotto;
        this.bonusNum = bonusNum;
    }

    public static WinningLotto createWinningLotto(List<String> numbersInput, String bonusNumInput) {
        List<Integer> numbers = validateNumbers(numbersInput);
        int bonusNum = validateBonusNumber(bonusNumInput);
        duplicateNumbersAndBonusNumber(numbers, bonusNum);

        return new WinningLotto(new Lotto(numbers), bonusNum);
    }

    public int countMatchLotto(Lotto generateLotto) {
        return this.lotto
                .countingMatchNumbers(generateLotto);
    }

    public boolean matchBonusNum(Lotto generateLotto) {
        return generateLotto.containsNumber(bonusNum);
    }

    private static int validateBonusNumber(String bonusNumInput) {
        includeChar(bonusNumInput);
        int bonusNum = validateRange(bonusNumInput);

        return bonusNum;
    }

    private static List<Integer> validateNumbers(List<String> numbersInput) {
        numbersInput.stream().forEach(WinningLotto::includeChar);
        List<Integer> numbers = numbersInput.stream()
                .map(WinningLotto::validateRange)
                .collect(Collectors.toList());

        return numbers;
    }

    private static void duplicateNumbersAndBonusNumber(List<Integer> numbers, int bonusNum) {
        if (numbers.contains(bonusNum)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getErrorMessage());
        }
    }

    private static void includeChar(String numberInput) {
        if (!numberInput.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(INCLUDE_CHAR.getErrorMessage());
        }
    }

    private static int validateRange(String numberInput) {
        try {
            int number = Integer.parseInt(numberInput);

            Lotto.validateLottoRange(number);

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_RANGE_LOTTO_NUMBER.getErrorMessage());
        }
    }
}
