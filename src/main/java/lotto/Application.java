package lotto;


import lotto.controller.LottoInputController;
import lotto.controller.LottoOutputController;
import lotto.dto.LottoGameInfo;
import lotto.dto.LottoResult;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoInputController lottoInputController = new LottoInputController();
        LottoOutputController lottoOutputController = new LottoOutputController();
        LottoGameInfo lottoGameInfo;
        try {
            lottoGameInfo = lottoInputController.createLottoGame();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lottoGameInfo = lottoInputController.createLottoGame();
        }
        lottoOutputController.printBuyLottos(lottoGameInfo);

        LottoResult lottoResult;
        try {
            lottoResult = lottoInputController.requestLottoResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lottoResult = lottoInputController.requestLottoResult();
        }
        lottoOutputController.resultMessage(lottoGameInfo,lottoResult);
    }
}
