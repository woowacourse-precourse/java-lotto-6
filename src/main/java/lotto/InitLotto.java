package lotto;

import java.util.List;

public class InitLotto {
    int amount;
    int bonusNumber;
    List<Integer> WinningNumbers;
    List<Lotto> lottos;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return WinningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        WinningNumbers = winningNumbers;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
