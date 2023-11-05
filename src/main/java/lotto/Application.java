package lotto;

import lotto.controller.Lottogame;
import lotto.domain.Generate;
import lotto.domain.Money;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Lottogame lottogame = new Lottogame();
        lottogame.start();
    }
}
