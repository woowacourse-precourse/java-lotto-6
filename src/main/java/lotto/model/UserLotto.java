package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {
    private int purchasePrice;
    private int winningPrice;
    private List<Lotto> lottos;

    public UserLotto(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        this.winningPrice = 0;
        this.lottos = new ArrayList<>();
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setWinningPrice(int winningPrice) {
        this.winningPrice = this.winningPrice + winningPrice;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
