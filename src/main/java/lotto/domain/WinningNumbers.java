package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {

    private List<Integer> winningNumbers;
    private BonusNumber bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자를 입력 바랍니다.");
        }
        Set<Integer> inputSet = new HashSet<>(winningNumbers);
        if (inputSet.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("중복된 수는 입력할 수 없습니다.");
        }
        for (int number : winningNumbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException("1 - 45의 숫자를 입력해 주세요");
            }
        }
        if (winningNumbers.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException("중복된 수는 입력할 수 없습니다.");
        }
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }
}
