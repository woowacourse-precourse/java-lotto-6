package lotto;

import java.util.List;

public class GameData {
    private Integer budget;
    private Integer LotteriesNumber;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public Integer getLotteriesNumber() {
        return LotteriesNumber;
    }

    public void setLotteriesNumber(Integer lotteriesNumber) {
        LotteriesNumber = lotteriesNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
