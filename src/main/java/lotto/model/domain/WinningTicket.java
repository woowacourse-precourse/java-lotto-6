package lotto.model.domain;


import java.util.List;

public class WinningTicket {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningTicket(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
