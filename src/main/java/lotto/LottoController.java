package lotto;

import java.util.List;

public class LottoController {
    InputView inputView;
    OutputView outputView;
    LottoMachine lottoMachine;

    LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoMachine = new LottoMachine();
    }

    public void start() {
        List<Lotto> lottos = buyLotto();
    }

    private List<Lotto> buyLotto() {
        try {
            int money = inputView.inputPurchaseAmount();
            return lottoMachine.buy(money);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return buyLotto();
        }
    }
}
