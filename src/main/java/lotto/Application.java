package lotto;

import static lotto.controller.LottoController.*;

import lotto.controller.LottoController;
import lotto.view.LottoView;
public class Application {
    public static void main(String[] args) {

        LottoController lottoController = new LottoController();
        int price = lottoController.processInputPurchaseAmount();
        lottoController.processCreateLotto(price);
        lottoController.processInputWinningNumber();
        lottoController.processInputBonusNumber();
        lottoController.processCheckWinningNumbers(lottoList,totalWinningNumbers,bonusNumber);
        lottoController.calculateTotalRate();
    }
}
