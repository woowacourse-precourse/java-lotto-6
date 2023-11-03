package lotto.domain;

import java.util.List;

public class WinningNumber {
    private static final int WINNING_NUMBER_SIZE = 6;

    private final List<Integer> winningNumber;
    private int bonusNumber;

    public WinningNumber(List<Integer> winningNumber) {
        validateWinningNumber(winningNumber);
        this.winningNumber = sorted(winningNumber);
    }

    private List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    private void validateWinningNumber(List<Integer> winningNumber) {
        validateSize(winningNumber);
        validateDuplicate(winningNumber);
        winningNumber.forEach(this::validateRange);
    }

    private void validateSize(List<Integer> winningNumber) {
        if (winningNumber.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 6개만 가능합니다");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int noDuplicate = numbers.stream().distinct().toList().size();

        if (noDuplicate != numbers.size()) {
            throw new IllegalArgumentException("당첨번호는 중복될 수 없습니다");
        }
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("1~45 사이의 숫자만 가능합니다");
        }
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicateBonusNumber(bonusNumber);
    }

    private void validateDuplicateBonusNumber(int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호에 이미 있는 수 입니다");
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
