package lotto.controller;


import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottosGenerator;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.domain.LottoResult;
import lotto.domain.WinnerLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();

    public void run() {
        LottosGenerator lottosGenerator = new LottosGenerator();

        Money money = getMoney();;

        Lottos lottos = lottosGenerator.generateLottos(getNumberOfPurchasedLottos(money));
        OutputView.printGeneratedLottos(lottos);

        Lotto lotto = getLotto();
        WinnerLotto winnerLotto = getWinnerLotto(lotto);

        Map<Prize, Long> prizeResults = getPrizeResults(lottos, winnerLotto);
        OutputView.printStatistics(prizeResults);
        OutputView.printProfitRate(getProfitRate(money, lottos, winnerLotto));
    }

    private Money getMoney() {
        Money money;
        while (true) {
            try {
                money = new Money(inputView.readMoney());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    private int getNumberOfPurchasedLottos(Money money) {
        int numberOfLottos = money.getNumberOfLottos();
        OutputView.printNumberOfPurchasedLottos(numberOfLottos);
        return numberOfLottos;
    }

    private Lotto getLotto() {
        Lotto lotto;
        while (true) {
            try {
                lotto = new Lotto(inputView.readLottoNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto;
    }

    private WinnerLotto getWinnerLotto(Lotto lotto) {
        WinnerLotto winnerLotto;
        while (true) {
            try {
                BonusNumber bonusNumber = new BonusNumber(inputView.readBonusNumber());
                winnerLotto = new WinnerLotto(lotto, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winnerLotto;
    }

    private Map<Prize, Long> getPrizeResults(Lottos lottos, WinnerLotto winnerLotto) {
        LottoResult lottoResult = new LottoResult(lottos, winnerLotto);
        return lottoResult.getPrizeResult();
    }

    private Double getProfitRate(Money money, Lottos lottos, WinnerLotto winnerLotto) {
        LottoResult lottoResult = new LottoResult(lottos, winnerLotto);
        return lottoResult.calculateProfitRate(money.getMoney(), lottoResult.getPrizeResult());
    }
}
