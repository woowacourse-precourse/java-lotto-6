package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.domain.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        InputView inputView = new InputView();
        Money money = new Money(inputView.askPrice());
        LottoStore lottoStore = new LottoStore(money);

        int lottoQuantity = lottoStore.getLottoQuantity(money);

        OutputView outputView = new OutputView();
        outputView.printPurchaseQuantity(lottoQuantity);

        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        outputView.printLottos(lottoStore.generateLotto());

        Lotto lotto = randomLottoGenerator.inputToGenerateLotto(inputView.askWinningNumber());
        lotto.validationDuplicate(new LottoNumber(inputView.askBonusWinningNumber()));

        outputView.printWinningStatistics();

    }
}
