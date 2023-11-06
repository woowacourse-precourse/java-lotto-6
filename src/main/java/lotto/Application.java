package lotto;

import lotto.controller.LottoInputController;
import lotto.controller.LottoOutputController;
import lotto.dto.LottoGameInfo;
import lotto.dto.LottoResult;
import lotto.view.input.ProxyInputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoInputController lottoInputController = new LottoInputController(new ProxyInputView());
        LottoOutputController lottoOutputController = new LottoOutputController();

        LottoGameInfo lottoGameInfo = lottoInputController.createLottoGame();
        lottoOutputController.printBuyLottos(lottoGameInfo);

        LottoResult lottoResult = lottoInputController.requestLottoResult();
        lottoOutputController.resultMessage(lottoGameInfo,lottoResult);
    }
}
