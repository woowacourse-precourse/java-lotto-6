package lotto;

import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.util.StringUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printLottoPurchaseMessage();
        String inputMoney = inputView.input();
        outputView.printLineSeparator();

        Buyer buyer = new Buyer(inputMoney);
        outputView.printLottoCountMessage(buyer.getLottoCount());
        buyer.printLottos();
        outputView.printLineSeparator();

        outputView.printWinningNumberMessage();
        String inputWinningNumbers = inputView.input();
        outputView.printBonusNumberMessage();
        String inputBonusNumber = inputView.input();
        Lotto inputLotto = new Lotto(StringUtils.convertStringToList(inputWinningNumbers));
        WinningLotto winningLotto = new WinningLotto(inputLotto, Integer.parseInt(inputBonusNumber));

        inputView.close();
    }
}
