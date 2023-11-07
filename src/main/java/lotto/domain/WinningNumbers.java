package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {

    private final List<Integer> winningNumbers;
    private final BonusNumber bonusNumber;

    private static final String NUMBER_SIZE_EXCEPTION = "당첨 번호는 6개의 숫자를 입력 바랍니다";
    private static final String NUMBER_RANGE_EXCEPTION = "1 부터 45 까지의 숫자를 입력해 주세요.";
    private static final String DUPLICATE_NUMBER_EXCEPTION = "중복된 수는 입력할 수 없습니다.";


    public WinningNumbers(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        Set<Integer> inputSet = new HashSet<>(winningNumbers);
        if (inputSet.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION);
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(NUMBER_SIZE_EXCEPTION);
        }
        for (int number : winningNumbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION);
            }
        }
        if (winningNumbers.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION);
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
