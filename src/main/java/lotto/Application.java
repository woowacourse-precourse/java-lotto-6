package lotto;

import lotto.LottoGameController.LottoGameController;
import lotto.service.LottoService;
import lotto.util.Utils;
import lotto.service.InputService;
import lotto.service.OutputService;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException {


        // TODO: 프로그램 구현

        LottoGameController lottoGameController = new LottoGameController(new InputService(), new OutputService(), new LottoService());
        lottoGameController.start();
    }
}
