package lotto.domain;

import java.util.List;

public class LottoWallet {
    private final List<Lotto> wallet;

    public LottoWallet(List<Lotto> wallet) {
        this.wallet = wallet;
    }

    public List<Lotto> getWallet() {
        return wallet;
    }
}
