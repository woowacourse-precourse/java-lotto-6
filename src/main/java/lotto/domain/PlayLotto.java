package lotto.domain;

public class PlayLotto {
    private static final int LOTTO_UNIT = 1000;
//    private static final String BUY_LOTTO = "개를 구매했습니다.";

    private int money;

    public PlayLotto(int money) {
        this.money = money;
    }

    public int lottoTry() {
        return money / LOTTO_UNIT;
    }
}
