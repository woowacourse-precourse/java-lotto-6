
package lotto.domain;

import lotto.constants.AppConstants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private List<Integer> winningNumber;
    private int bonusNumber;

    public WinningNumbers (String str) {
        validateWinningNumber();
        this.winningNumber = getWinningNumberList(str);
    }

    private void validateWinningNumber() {

    }

    private List<Integer> getWinningNumberList(String strNum) {
        return Arrays.stream(strNum.split(AppConstants.INPUT_DELIMITER.name()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

}