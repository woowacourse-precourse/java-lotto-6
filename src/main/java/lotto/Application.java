package lotto;

import lotto.factory.LottoFactory;

public class Application {
    public static void main(String[] args) {
        LottoFactory lottoFactory = new LottoFactory();
        lottoFactory.lottoController().run();
    }
}
