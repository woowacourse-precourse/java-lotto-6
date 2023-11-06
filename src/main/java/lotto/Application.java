package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyLotto buyLotto = new BuyLotto();
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> balls;
        int lottoCount = buyLotto.buy();

        for (int i = 0; i < lottoCount; i++) {
            balls = numberGenerator.generateBall();
            System.out.println(balls.toString());
        }
    }
}
