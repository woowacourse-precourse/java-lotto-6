package lotto.view;

import static lotto.view.OutputMessage.*;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public void askPurchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT.getMessage());
    }

    public void askLottoWinningNumber() {
        printNewLine();
        System.out.println(ENTER_LOTTO_NUMBERS.getMessage());
    }

    public void askBonusNumber() {
        printNewLine();
        System.out.println(ENTER_BONUS_NUMBER.getMessage());
    }

    public void printPurchasedResult(List<Lotto> purchasedLotto, int purchasedGameCount) {
        printNewLine();
        printPurchasedGameCount(purchasedGameCount);
        printPurchasedLottoNumbers(purchasedLotto);
    }

    private void printPurchasedGameCount(int purchasedGameCount) {
        System.out.printf(SHOW_LOTTO_GAME_COUNT.getMessage(), purchasedGameCount);
        printNewLine();
    }

    private void printPurchasedLottoNumbers(List<Lotto> purchasedLotto) {
        for (Lotto eachLotto : purchasedLotto) {
            System.out.println(eachLotto.getNumbers());
        }
    }


    public void printNewLine() {
        System.out.println();
    }
}