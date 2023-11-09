package lotto;

import lotto.factory.ComponentFactory;

public class Application {
    public static void main(String[] args) {
        ComponentFactory.getInstance().lottoController().run();
    }
}
