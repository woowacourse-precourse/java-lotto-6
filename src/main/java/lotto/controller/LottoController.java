package lotto.controller;

import java.util.List;
import lotto.constants.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStore;
import lotto.domain.MatchedNumber;
import lotto.domain.Money;
import lotto.domain.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.LottoStatistics;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Money money = new Money(inputView.askPrice());
        LottoStore lottoStore = new LottoStore();

        outputView.printPurchaseQuantity(lottoStore.getLottoQuantity(money));
        List<Lotto> lottos = lottoStore.generateLotto();
        outputView.printLottos(lottos);

        Lotto lotto = new RandomLottoGenerator().inputToGenerateLotto(inputView.askWinningNumber());
        LottoNumber lottoNumber = new LottoNumber(inputView.askBonusWinningNumber());
        MatchedNumber matchedNumber = new MatchedNumber(lotto, lottoNumber);

        List<LottoRank> lottoRanks = matchedNumber.getLottoRanks(lottos);
        int totalWinnings = money.calculateTotalWinnings(lottoRanks);
        new LottoStatistics(lottoRanks).printStatistics();

        outputView.printRateOfReturn(money.calculateReturnOfRate(money.getMoney(), totalWinnings));
    }
}
