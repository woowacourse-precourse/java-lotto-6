package lotto.model;

import java.util.*;

public class LottoManager {
    private final List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoManager(List<Integer> winningNumbers) {
        validateWinningNumbersRange(winningNumbers);
        validateWinningNumbers(winningNumbers);
        validateNoDuplicateNumbers(winningNumbers);
        this.winningNumbers = new ArrayList<>(winningNumbers);
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateWinningNumbersRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream().anyMatch(number -> number < 1 || number > 45);
        if (isOutOfRange) {
            throw new IllegalArgumentException("로또 번호는 1에서 45 사이여야 합니다.");
        }
    }

    private void validateNoDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호에 중복된 숫자가 있습니다.");
        }
    }

    private void validateNoDuplicateBonusNumber(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호에 당첨 번호와 중복된 숫자가 있습니다.");
        }
        this.bonusNumber = bonusNumber;
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        boolean isOutOfRange = bonusNumber < 1 || bonusNumber > 45;
        if (isOutOfRange) {
            throw new IllegalArgumentException("보너스 번호는 1에서 45 사이여야 합니다.");
        }
    }

    public void addBonusNumber(int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateNoDuplicateBonusNumber(bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
