package lotto;


import lotto.controller.LottoInputController;
import lotto.controller.LottoOutputController;
import lotto.dto.LottoGameInfo;
import lotto.dto.LottoResult;
import lotto.view.input.LottoNumberInputView;
import lotto.view.input.LottoShopInput;
import lotto.view.output.LottoBuyOutputView;
import lotto.view.output.LottoResultOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoInputController lottoInputController =
                new LottoInputController(new LottoShopInput(), new LottoNumberInputView());

        LottoGameInfo lottoGameInfo = lottoInputController.createLottoGame();

        LottoOutputController lottoOutputController =
                new LottoOutputController(new LottoBuyOutputView(), new LottoResultOutputView());

        lottoOutputController.printBuyLottos(lottoGameInfo);
        LottoResult lottoResult = lottoInputController.requestLottoResult();

        lottoOutputController.resultMessage(lottoGameInfo,lottoResult);

    }
}
