package lotto;

public class WinningLottoDTO {
    Lotto lotto;
    int bonusNumber;

    WinningLottoDTO(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }
}
