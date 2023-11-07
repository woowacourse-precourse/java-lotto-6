package lotto;

import lotto.config.AppConfig;
import lotto.domain.LottoGame;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame lottoGame = LottoGame.builder()
                .userInterface(AppConfig.userInterface())
                .lottoMachine(AppConfig.lottoMachine())
                .build();
        lottoGame.play();
    }
}
