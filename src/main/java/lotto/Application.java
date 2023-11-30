package lotto;

import lotto.controller.LottoController;
import lotto.model.Profit;
import lotto.model.Validator;
import lotto.model.service.LottoService;
import lotto.view.Input;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService(new Profit(),new Input(),new Output(),new Validator());
        LottoController lottoController = new LottoController(lottoService);
        lottoController.start();
    }
}
