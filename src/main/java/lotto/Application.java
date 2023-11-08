package lotto;

import lotto.controller.LottoGameController;
import lotto.dto.LottoGameInfo;
import lotto.view.input.ProxyInputView;
import lotto.view.output.LottoBuyOutputView;
import lotto.view.output.LottoResultOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGameController lottoGameController =
                new LottoGameController(new ProxyInputView(), new LottoBuyOutputView(), new LottoResultOutputView());

        LottoGameInfo lottoGameInfo = lottoGameController.startLottoGame();
        lottoGameController.printLottoResult(lottoGameInfo);
    }
}
