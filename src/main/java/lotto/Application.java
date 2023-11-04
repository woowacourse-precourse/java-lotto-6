package lotto;

import lotto.container.ApplicationConfigAutoWiring;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new ApplicationConfigAutoWiring().lottoController().run();
    }
}
