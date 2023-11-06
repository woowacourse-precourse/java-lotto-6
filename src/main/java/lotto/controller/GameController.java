package lotto.controller;

import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.PlayerLottos;
import lotto.model.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    public void start() {
        Purchase purchase = createPurchase();
        printLottoAmount(purchase);
        PlayerLottos playerLottos = new PlayerLottos(purchase.getLottoAmount());

        Lotto winningLotto = createWinningLotto();
        Bonus bonus = createBonus(winningLotto);
    }

    private void printLottoAmount(Purchase purchase) {
        int lottoAmount = purchase.getLottoAmount();
        OutputView.printLottoAmount(lottoAmount);
    }

    private Purchase createPurchase() {
        while (true) {
            try {
                int purchaseMoney = getPurchaseMoney();
                return new Purchase(purchaseMoney);
            } catch (IllegalArgumentException e) {
                InputView.printErrorMessage(e);
            }
        }
    }

    private int getPurchaseMoney() {
        return InputView.getPurchaseMoney();
    }

    private Lotto createWinningLotto() {
        while (true) {
            try {
                List<Integer> numbers = getWinningLottoNumbers();
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                InputView.printErrorMessage(e);
            }
        }
    }

    private List<Integer> getWinningLottoNumbers() {
        return InputView.getWinningLottoNumbers();
    }

    private Bonus createBonus(Lotto lotto) {
        while (true) {
            try {
                int bonusNumber = getBonusNumber();
                return new Bonus(bonusNumber, lotto);
            } catch (IllegalArgumentException e) {
                InputView.printErrorMessage(e);
            }
        }
    }

    private int getBonusNumber() {
        return InputView.getBonusNumber();
    }
}