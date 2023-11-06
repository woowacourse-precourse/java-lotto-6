package lotto.model;

public class Store {
    private final int lottoCount;

    public Store(int money) {
        lottoCount = countLotto(money);
    }

    public static int countLotto(int money) {
        return money / 1000;
    }

}
