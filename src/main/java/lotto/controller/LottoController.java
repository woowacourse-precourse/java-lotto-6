package lotto.controller;


import java.util.List;
import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.LottosGenerator;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.domain.PrizeResult;
import lotto.domain.WinnerLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        LottosGenerator lottosGenerator = new LottosGenerator();

        Money money = getMoney();
        int numberOfLottos = getNumberOfPurchasedLottos(money);

        Lottos lottos = lottosGenerator.generateLottos(numberOfLottos);
        OutputView.printGeneratedLottos(lottos);

        WinnerLotto winnerLotto = getWinnerLotto();

        Map<Prize, Long> prizeResults = getPrizeResults(lottos, winnerLotto);
        OutputView.printStatistics(prizeResults);
        OutputView.printProfitRate(getProfitRate(money, lottos, winnerLotto));
    }

    private Money getMoney() {
        InputView inputView = new InputView();
        return new Money(inputView.readMoney());
    }

    private int getNumberOfPurchasedLottos(Money money) {
        int numberOfLottos = money.getNumberOfLottos();
        OutputView.printNumberOfPurchasedLottos(numberOfLottos);
        return numberOfLottos;
    }

    private WinnerLotto getWinnerLotto() {
        InputView inputView = new InputView();
        List<Integer> lottoNumbers = inputView.readLottoNumbers();
        Integer bonusNumber = inputView.readBonusNumber();
        return new WinnerLotto(lottoNumbers, bonusNumber);
    }

    private Map<Prize, Long> getPrizeResults(Lottos lottos, WinnerLotto winnerLotto) {
        PrizeResult prizeResult = new PrizeResult(lottos, winnerLotto);
        return prizeResult.getPrizeResult();
    }

    private Double getProfitRate(Money money, Lottos lottos, WinnerLotto winnerLotto) {
        PrizeResult prizeResult = new PrizeResult(lottos, winnerLotto);
        return prizeResult.calculateProfitRate(money.getMoney(), prizeResult.getPrizeResult());
    }
}
