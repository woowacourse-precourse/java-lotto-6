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
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("당첨 번호는 %d개여야 합니다.",LottoConstants.LOTTO_NUMBER_COUNT));
        }
    }

    private void validateWinningNumbersRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream().anyMatch(number -> number < LottoConstants.LOTTO_START_NUMBER || number > LottoConstants.LOTTO_END_NUMBER);
        if (isOutOfRange) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d에서 %d 사이여야 합니다.",LottoConstants.LOTTO_START_NUMBER, LottoConstants.LOTTO_END_NUMBER));
        }
    }

    private void validateNoDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
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
        boolean isOutOfRange = bonusNumber < LottoConstants.LOTTO_START_NUMBER || bonusNumber > LottoConstants.LOTTO_END_NUMBER;
        if (isOutOfRange) {
            throw new IllegalArgumentException(String.format("보너스 번호는 %d에서 %d 사이여야 합니다.",
                    LottoConstants.LOTTO_START_NUMBER, LottoConstants.LOTTO_END_NUMBER));
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
