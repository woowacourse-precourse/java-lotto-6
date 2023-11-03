package lotto;

import lotto.factory.Factory;

public class Application {
    public static void main(String[] args) {
        Factory lottoFactory = new Factory();
        lottoFactory.lottoController().run();
    }
}
