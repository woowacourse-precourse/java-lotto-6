package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.game.LottoGame;
import lotto.provider.LottoInputProvider;
import lotto.provider.LottoOutputProvider;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoInputProvider lottoInputProvider = new LottoInputProvider();
        LottoOutputProvider lottoOutputProvider = new LottoOutputProvider();
        LottoService lottoService = new LottoService();
        LottoGame lottoGame = new LottoGame(lottoInputProvider, lottoOutputProvider, lottoService);

        lottoGame.start();

    }
}
