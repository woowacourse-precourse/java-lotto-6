package game;

import account.UserAccount;
import console.InputView;
import console.OutputView;
import calculator.IncomeCalculator;
import lotto.Lotto;
import lotto.Lottos;
import lotto.StandardLotto;

public class LottoController {
    private LottoController() {
        throw new UnsupportedOperationException();
    }

    public static void game(){
        UserAccount userAccount = startAndCreateUserAccount();
        int trialCount = userAccount.getTrialCount();

        Lottos randomLottos = generateRandomLottosByTrialCount(trialCount);

        StandardLotto standardLotto = getStandardLottoByUserInputs();
        
        randomLottos.calculateWinning(standardLotto);

        printEarnings(userAccount);
    }

    private static void printEarnings(UserAccount userAccount) {
        OutputView.printEarningDetail();
        long totalWinning = IncomeCalculator.getTotalIncome();
        double earningRate = userAccount.getEarningRate(totalWinning);
        OutputView.printTotalEarningRate(earningRate);
    }

    private static StandardLotto getStandardLottoByUserInputs() {
        OutputView.printInputLottoNumber();
        Lotto userLotto = InputView.getLottoInput();
        OutputView.printInputBonusNumber();
        Integer bonusNumber = InputView.getBonusNumberByUser(userLotto);

        return new StandardLotto(userLotto, bonusNumber);
    }

    private static Lottos generateRandomLottosByTrialCount(int trialCount) {
        OutputView.printPurchaseAmountIs(trialCount);
        Lottos randomLottos = Lottos.ofRandom(trialCount);
        OutputView.printLottosNumber(randomLottos);
        return randomLottos;
    }

    private static UserAccount startAndCreateUserAccount() {
        OutputView.printInputPurchaseAmount();
        Integer money = InputView.getMoney();
        return new UserAccount(money);
    }
}
