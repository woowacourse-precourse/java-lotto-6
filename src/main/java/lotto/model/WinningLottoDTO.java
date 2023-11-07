package lotto.model;

public class WinningLottoDTO {
    Lotto lotto;
    int bonusNumber;

    public WinningLottoDTO(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
