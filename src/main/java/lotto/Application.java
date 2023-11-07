package lotto;

import lotto.core.Lottery;

public class Application {
    public static void main(String[] args) {
        Lottery lottery = new Lottery();

        lottery.ready();
        lottery.start();
        lottery.end();
    }
}
