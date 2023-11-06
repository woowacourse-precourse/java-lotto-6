package lotto;

import lotto.controller.LottoController;
import lotto.view.InputMapper;
import lotto.view.LottoView;

public class Application {

    public static void main(String[] args) {
        InputMapper inputMapper = new InputMapper();
        LottoView lottoView = new LottoView(inputMapper);
        LottoController lottoController = new LottoController(lottoView);
        lottoController.run();
    }
}
