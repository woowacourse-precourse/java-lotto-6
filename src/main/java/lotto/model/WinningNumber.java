package lotto.model;

import java.util.List;

public class WinningNumber {
    private final List<Integer> winNumber;
    private Integer bonusNumber;

    public WinningNumber(List<Integer> winNumber) {
        validate(winNumber);
        this.winNumber = winNumber;
    }

    private void validate(List<Integer> winNumber) {
        if (winNumber.size() != winNumber.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getWinNumber() {
        return winNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
