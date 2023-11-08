package lotto;

import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.util.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Money money = getMoney();
        LottoCount lottoCount = getLottoCount(money);

        Lottos lottos = getLottos(lottoCount);

        WinningLotto winningLotto = createWinningLotto();
        Result result = new Result(lottos, winningLotto);

        printResult(result, money);
    }

    private static Money getMoney() {
        OutputView.printInputMoneyMessage();
        return InputView.inputMoney();
    }

    private static LottoCount getLottoCount(Money money) {
        LottoCount lottoCount = new LottoCount(money);
        OutputView.printLottoCount(lottoCount);
        return lottoCount;
    }

    private static Lottos getLottos(LottoCount lottoCount) {
        Lottos lottos = LottoGenerator.generateLottos(lottoCount);
        OutputView.printPurchasedLotto(lottos);
        return lottos;
    }

    private static WinningLotto createWinningLotto() {
        OutputView.printInputWinningLottoNumbersMessage();
        Lotto winningLotto = InputView.inputWinningLottoNumbers();

        OutputView.printInputBonusNumberMessage();
        int bonusNumber = InputView.inputBonusNumber();

        return new WinningLotto(winningLotto, bonusNumber);
    }

    private static void printResult(Result result, Money money) {
        OutputView.printStatistic(result);
        OutputView.printYield(result, money);
    }
}
