package lotto;

import lotto.config.AppConfig;
import lotto.domain.LottoMachine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        LottoMachine lottoMachine = appConfig.lottoMachine();
        lottoMachine.start();
    }
}
