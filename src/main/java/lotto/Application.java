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
        outputView.printLineSeparator();

        Buyer buyer = new Buyer(inputMoney);
        outputView.printLottoCountMessage(buyer.getLottoCount());
        buyer.printLottos();

        inputView.close();
    }
}
