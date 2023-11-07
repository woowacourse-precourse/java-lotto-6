package lotto;

import lotto.domain.LottoGameManager;

public class Application {
    public static void main(String[] args) {
        LottoGameManager lottoGameManager = new LottoGameManager();
        lottoGameManager.start();
    }
}
