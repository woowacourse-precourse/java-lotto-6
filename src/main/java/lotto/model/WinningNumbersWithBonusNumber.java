package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningNumbersWithBonusNumber {

    private List<Integer> winningNumbersWithBonusNumber = new ArrayList<>();

    public WinningNumbersWithBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        saveWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);
    }

    private void saveWinningNumbersAndBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        winningNumbersWithBonusNumber.add(bonusNumber);
        winningNumbersWithBonusNumber.addAll(winningNumbers);
    }

    public List<Integer> getWinningNumbersWithBonusNumber() {
        return Collections.unmodifiableList(winningNumbersWithBonusNumber);
    }
}
