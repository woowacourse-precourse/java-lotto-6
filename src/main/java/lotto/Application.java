package lotto;

import lotto.config.LottoGameConfig;

public class Application {
    public static void main(String[] args) {
        LottoGameConfig lottoGameConfig = new LottoGameConfig();
        lottoGameConfig.lottoGameController().run();
    }
}
