package lotto;

import lotto.generator.RandomLottoNumberGenerator;
import lotto.lotto.LottoService;

public class Application {
    public static void main(String[] args) {
        RandomLottoNumberGenerator generator = new RandomLottoNumberGenerator();
        LottoService lottoService = new LottoService(generator);
        LottoGame lottoGame = new LottoGame(lottoService);
        lottoGame.run();
    }
}
