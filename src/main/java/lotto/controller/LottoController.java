package lotto.controller;

import static lotto.util.Conversion.stringToInt;
import static lotto.util.Conversion.stringToList;
import static lotto.util.message.Guide.BONUS_NUMBER;
import static lotto.util.message.Guide.PURCHASE_AMOUNT;
import static lotto.util.message.Guide.WINNING_NUMBER;
import static lotto.view.InputView.input;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Purchase;
import lotto.model.WinningNumber;
import lotto.model.WinningResult;
import lotto.view.OutputView;

public class LottoController {

    private Purchase purchase;
    private Lottos lottos;
    private WinningNumber winningLotto;
    private BonusNumber bonusNumber;

    public void run() {
        payMoney();
        buyLottos();
        getWinningLotto();
        getBonusLotto();
        showWinningResult();
    }

    private void payMoney() {
        try {
            int money = stringToInt(input(PURCHASE_AMOUNT.getMessage()));
            purchase = new Purchase(money);
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception.getMessage());
            payMoney();
        }
    }

    private void buyLottos() {
        int count = purchase.getCount();

        List<Lotto> lotto = Lotto.generator(count);
        lottos = new Lottos(lotto);

        OutputView.printLottoInfo(lotto, count);
    }

    private void getWinningLotto() {
        String winningNumber = input(WINNING_NUMBER.getMessage());

        try {

            winningLotto = new WinningNumber(stringToList(winningNumber));

        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception.getMessage());
            getWinningLotto();
        }
    }

    private void getBonusLotto() {
        String bonus = input(BONUS_NUMBER.getMessage());

        try {
            bonusNumber = new BonusNumber(stringToInt(bonus), winningLotto.getWinning());
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception.getMessage());
            getBonusLotto();
        }
    }

    private void showWinningResult() {
        WinningResult.checkWinning(bonusNumber.getBonus(), winningLotto.getWinning(), lottos.getLottos());
        OutputView.printResultStatistics();
    }
}
