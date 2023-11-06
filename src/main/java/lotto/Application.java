package lotto;

import lotto.model.Buyer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printLottoPurchaseComment();
        String inputMoney = inputView.inputLottoPurchaseAmount();

        Buyer buyer = new Buyer(inputMoney);
    }
}
