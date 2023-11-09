package lotto.controller;

import java.util.List;
import lotto.domain.BonusBall;
import lotto.domain.BuyLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.view.OutputView;
import lotto.domain.Score;
import lotto.view.UserInput;
import lotto.domain.WinStatistics;

public class LottoController {

    private final UserInput userInput;

    public LottoController() {
        this.userInput = new UserInput();
    }

    public void startLotto() {
        Money money = inputMoney();
        LottoNumbers lottoNumbers = getLottoNumbers(money);
        Lotto lotto = inputLotto();
        result(lottoNumbers, lotto);
    }

    private static LottoNumbers getLottoNumbers(Money money) {
        LottoNumbers lottoNumbers = new BuyLotto().lotto(money);
        purchaseResult(money, lottoNumbers);
        return lottoNumbers;
    }

    private void result(LottoNumbers lottoNumbers, Lotto lotto) {
        BonusBall bonusBall = inputBonusBall(lotto);
        Score score = lottoNumbers.calculateScore(lotto, bonusBall);
        long revenue = score.getPrize();
        List<Integer> scores = score.getScores();
        OutputView.printWinStatistics(WinStatistics.getStatisticsString(scores, revenue));
    }

    private static void purchaseResult(Money money, LottoNumbers lottoNumbers) {
        OutputView.printPurchased(money.availableCount());
        OutputView.printGeneratedLotto(lottoNumbers.toString());
    }

    private Money inputMoney() {
        Money money = isInValidMoney();
        while (money == null) {
            money = isInValidMoney();
        }
        return money;
    }


    private Money isInValidMoney() {
        try {
            int money = userInput.money();
            return new Money(money);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return null;
        }
    }

    private Lotto inputLotto() {
        Lotto lotto = isInValidLottoNumber();
        while (lotto == null) {
            lotto = isInValidLottoNumber();
        }
        return lotto;
    }

    private Lotto isInValidLottoNumber() {
        try {
            List<Integer> winNumber = userInput.lottoNumber();
            return new Lotto(winNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return null;
        }
    }

    private BonusBall inputBonusBall(Lotto lotto) {
        BonusBall bonusBall = isInValidBonusBall(lotto);
        while (bonusBall == null) {
            bonusBall = isInValidBonusBall(lotto);
        }
        return bonusBall;
    }

    private BonusBall isInValidBonusBall(Lotto lotto) {
        try {
            int bonusBall = userInput.bonusBall();
            return new BonusBall(bonusBall, lotto);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return null;
        }
    }
}
