package lotto.domain;

import java.util.List;
import lotto.Lotto;

public class PlayerLotto {
    private final List<Lotto> playerLottos;
    private final int purchasesPrice;
    private final int lottoAmount;

    public PlayerLotto(int price) {
        this.purchasesPrice = price;
        this.lottoAmount = price / 1000;
        this.playerLottos = createPlayerLottos();
    }

    private List<Lotto> createPlayerLottos() {
        return null;
    }

    public List<Lotto> getPlayerLottos() {
        return this.playerLottos;
    }

    public int getPurchasesPrice() {
        return purchasesPrice;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }
}
