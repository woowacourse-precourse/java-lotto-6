package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyLotto buyLotto = new BuyLotto();
        int lottoCount = buyLotto.buy();

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = buyLotto.generateLotto();
            List<Integer> balls = lotto.showBallNumber();
            System.out.println(balls.toString());
        }

        System.out.println(buyLotto.inputNumbers().toString());
    }
}
