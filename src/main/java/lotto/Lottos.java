package lotto;

public class Lottos {
    public int calculateLottoCount(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("로또는 1000원 단위만 구매할 수 있습니다.");
        }
        return money / 1000;
    }
}
