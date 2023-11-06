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

        //1,2번 로직 묶어서 하나의 컨트롤러로 만들기
        //1 
        LottoGameInfo lottoGameInfo = lottoInputController.createLottoGame();
        lottoOutputController.printBuyLottos(lottoGameInfo);

        //2
        LottoResult lottoResult = lottoInputController.requestLottoResult();
        lottoOutputController.resultMessage(lottoGameInfo,lottoResult);
    }
}
