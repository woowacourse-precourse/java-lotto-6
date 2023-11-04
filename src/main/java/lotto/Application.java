package lotto;

import lotto.controller.LottoController;
import lotto.handler.UserHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        UserHandler.getAmountFromUser();

        LottoController lottoController = new LottoController();
        lottoController.buyLottos();
    }
}

