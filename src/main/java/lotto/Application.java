package lotto;

import lotto.controller.LottoGameController;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.utils.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        LottoService lottoService = new LottoService(randomNumberGenerator);
        LottoGameController lottoGameController = new LottoGameController(lottoService);
        lottoGameController.run();
    }
}
