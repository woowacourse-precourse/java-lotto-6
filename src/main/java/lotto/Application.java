package lotto;

import lotto.domain.LottoGameController;
import lotto.domain.LottoStore;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(new LottoStore());
        lottoGameController.run();
    }
}
