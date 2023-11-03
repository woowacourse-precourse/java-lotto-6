package lotto.domain;

import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.ui.message.OutputMessage;

import java.util.List;

public class LottoGame {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    LottoMachine lottoMachine = new LottoMachine();

    public void doLottoGame() {

        Money money = getMoney();
        List<Lotto> lottoBundle = lottoMachine.buyLotto(money);

        printIssuedLotto(lottoBundle);

    }

    private void printIssuedLotto(List<Lotto> lottoBundle) {
        outputView.printLottoCount(lottoBundle.size());
        outputView.printLottoBundle(lottoBundle);
    }

    private Money getMoney() {
        outputView.print(OutputMessage.GET_PURCHASE_MONEY);
        Money money = inputView.getMoney();
        return money;
    }


}
