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

        WinLotto winLotto = getWinLotto();

        LottoResult lottoResult = new LottoResult(lottoBundle, winLotto);
        Double earningRatio = lottoResult.calculateEarningRatio(money);

        printLottoResult(lottoResult, earningRatio);

    }

    private Money getMoney() {
        outputView.print(OutputMessage.GET_PURCHASE_MONEY);
        Integer amount = inputView.getMoney();
        return new Money(amount); // todo:예외처리
    }

    private void printIssuedLotto(List<Lotto> lottoBundle) {
        outputView.printLottoCount(lottoBundle.size());
        outputView.printLottoBundle(lottoBundle);
    }

    private WinLotto getWinLotto() {
        outputView.print(OutputMessage.GET_WIN_NUMBERS);
        List<Integer> winLottoNumbers = inputView.getWinLottoNumbers();

        outputView.print(OutputMessage.GET_BONUS_NUMBER);
        Integer winLottoBonus = inputView.getWinLottoBonus();

        return new WinLotto(winLottoNumbers, winLottoBonus); // todo:예외처리
    }

    private void printLottoResult(LottoResult lottoResult, Double earningRatio) {
        outputView.printLottoResult(lottoResult, earningRatio);
    }

}
