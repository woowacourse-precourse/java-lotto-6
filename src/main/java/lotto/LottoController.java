package lotto;

import account.UserAccount;
import console.InputView;
import console.OutputView;

public class LottoController {
    private LottoController() {
        throw new UnsupportedOperationException();
    }

    public static void game(){
        OutputView.printInputPurchaseAmount();
        Integer money = InputView.getMoney();
        UserAccount userAccount = new UserAccount(money);
        int trialCount = userAccount.getTrialCount();
        OutputView.printPurchaseAmountIs(trialCount);

        Lottos randomLottos = Lottos.ofRandom(trialCount);
        OutputView.printLottosNumber(randomLottos);

        OutputView.printInputLottoNumber();
        Lotto userLotto = InputView.getLottoInput();
        OutputView.printInputBonusNumber();
        Integer bonusNumber = InputView.getBonusNumber(userLotto);

        StandardLotto standardLotto = new StandardLotto(userLotto, bonusNumber);
        randomLottos.calculateWinning(standardLotto);

        OutputView.printEarningDetail();
        long totalWinning = WinningCalculator.getTotalWinning();
        double earningRate = userAccount.getEarningRate(totalWinning);
        OutputView.printTotalEarningRate(earningRate);
    }
}
