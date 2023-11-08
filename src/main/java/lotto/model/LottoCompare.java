package lotto.model;
import java.util.List;

public class LottoCompare {
    private int bonusNumber;
    private List<Integer> winningNumbers;

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public boolean bonusCompare(Lotto lotto){
        return lotto.getNumbers().contains(getBonusNumber());
    }

    public int winningCompare(Lotto lotto){
        return (int) winningNumbers.stream()
                .filter(x -> lotto.getNumbers().contains(x))
                .count();
    }
}
