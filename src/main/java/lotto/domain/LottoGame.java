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
        while (true) {
            try {
                return new Money(inputView.readMoney());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void printIssuedLotto(List<Lotto> lottoBundle) {
        outputView.printLottoCount(lottoBundle.size());
        outputView.printLottoBundle(lottoBundle);
    }

    private WinLotto getWinLotto() {
        while (true) {
            try {
                List<Integer> winLottoNumbers = inputView.readWinLottoNumbers();
                Integer winLottoBonus = inputView.readWinLottoBonusNumber();

                return new WinLotto(winLottoNumbers, winLottoBonus);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

    }

    private void printLottoResult(LottoResult lottoResult, Double earningRatio) {
        outputView.printLottoResult(lottoResult, earningRatio);
    }

}
