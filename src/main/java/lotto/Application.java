package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String purchasePrice = InputView.purchasePrice();
        LottoController lottoController = new LottoController();
        List<Lotto> lottery = lottoController.buyLottery(purchasePrice);

        String winningNumber = InputView.winningNumber();
        String bonusNumber = InputView.bonusNumber();
    }
}
