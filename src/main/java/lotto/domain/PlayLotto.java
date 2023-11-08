package lotto.domain;

public class PlayLotto {
    private static final int LOTTO_UNIT = 0;
    private int money;

    public PlayLotto(int money) {
        this.money = money;
    }

    public int lottoTry() {
        return money / LOTTO_UNIT;
    }
}
