package lotto.game;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.Score;
import lotto.domain.Customer;
import lotto.global.Store;
import lotto.ui.Input;
import lotto.ui.Output;

public class Game {
    public void run() {
        LottoBundle lottoBundle = Store.generateLottoBundle(getUserPurchasePrice());
        Output.printLottoBundle(lottoBundle);
        Customer customer = makeLottoResult();
        Score score = lottoBundle.checkResult(customer);
        Output.printLottoResult(score);
    }

    private int getUserPurchasePrice() {
        try {
            Output.printPurchasePrice();
            final int count = Store.convertPriceToCount(Input.getPurchasePrice());
            Output.printPurchaseCount(count);
            return count;
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return getUserPurchasePrice();
        }
    }

    private Customer makeLottoResult() {
        try {
            final Lotto winningLotto = getUserLotto();
            final int bonusBall = getBonusBall();
            return new Customer(winningLotto, bonusBall);
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return makeLottoResult();
        }
    }

    private int getBonusBall() {
        try {
            Output.printBonusNumberInput();
            return Input.getBonusNumber();
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return getBonusBall();
        }
    }

    private Lotto getUserLotto() {
        try {
            Output.printUserNumberInput();
            final List<Integer> userLottoNumber = Input.getUserNumbers();
            return new Lotto(userLottoNumber);
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return getUserLotto();
        }
    }
}
