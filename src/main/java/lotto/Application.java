package lotto;

import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String purchaseAmount = inputView.readPurchaseAmount();
        Money money = new Money(purchaseAmount);

        String winnerNumber = inputView.readWinnerNumber();
        String BonusNumber = inputView.readBonusNumber();
    }
}
