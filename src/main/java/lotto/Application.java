package lotto;

import lotto.controller.LottoController;
import lotto.exception.LottoErrorMsg;
import lotto.exception.LottoException;

public class Application {
    public static void main(String[] args) {
//        throw new IllegalArgumentException(LottoErrorMsg.UNABLE_TO_DIVIDE.getMessage());
        LottoController lottoController = new LottoController();
        lottoController.buyLotto();

    }
}
