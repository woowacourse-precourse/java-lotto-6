package lotto.domain;

import lotto.exception.ThousandCheckException;
import lotto.exception.ZeroMoreThanException;

public class Coin {
    private final int coin;

    public Coin(int coin) {
        this.coin = coin;
    }

    public int getLottoPaper() {
        return coin / 1000;
    }

    public void zeroMoreThaCoin(int coin) {
        if (coin <= 0) {
            throw new ZeroMoreThanException();
        }
    }

    public void thousandCheck(int coin) {
        if (coin % 1000 != 0) {
            throw new ThousandCheckException();
        }
    }
}
