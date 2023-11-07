package lotto.domain;

import java.util.List;

public class LottoGame {
    private Long purchaseAmount;

    private List<Lotto> lottos;

    private Lotto winningNumber;

    private int bonusNumber;

    public LottoGame(Long purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Long getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(Long purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber(Lotto winningNumber) {
        this.winningNumber = winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
