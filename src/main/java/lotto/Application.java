package lotto;

import lotto.domain.Buy;

public class Application {
    public static void main(String[] args) {
        Buy buy = new Buy();
        // 로또 구매 및 발행
        buy.createGames();
    }
}
