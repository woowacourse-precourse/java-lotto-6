package lotto;

import lotto.generator.RandomLottoNumberGenerator;
import lotto.lotto.LottoController;
import lotto.lotto.LottoService;

public class Application {
    public static void main(String[] args) {
        RandomLottoNumberGenerator generator = new RandomLottoNumberGenerator();
        LottoService lottoService = new LottoService(generator);
        LottoController lottoController = new LottoController(lottoService);
        lottoController.start();
    }
}
