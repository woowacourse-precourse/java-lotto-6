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

    public void run() {
        InputView inputView = new InputView();
        Money money = new Money(inputView.askPrice());
        LottoStore lottoStore = new LottoStore(money);
        OutputView outputView = new OutputView();
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        int lottoQuantity = lottoStore.getLottoQuantity(money);
        outputView.printPurchaseQuantity(lottoQuantity);
        List<Lotto> lottos = lottoStore.generateLotto();
        outputView.printLottos(lottos);
        Lotto lotto = randomLottoGenerator.inputToGenerateLotto(inputView.askWinningNumber());
        LottoNumber lottoNumber = new LottoNumber(inputView.askBonusWinningNumber());
        MatchedNumber matchedNumber = new MatchedNumber(lotto, lottoNumber);
        List<LottoRank> lottoRanks = matchedNumber.getLottoRanks(lottos);
        int totalWinnings = money.calculateTotalWinnings(lottoRanks);
        double returnOfRate = money.calculateReturnOfRate(money.getMoney(), totalWinnings);
        LottoStatistics lottoStatistics = new LottoStatistics(lottoRanks);
        lottoStatistics.printStatistics();
        outputView.printRateOfReturn(returnOfRate);

    }
}
