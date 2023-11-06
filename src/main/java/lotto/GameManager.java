package lotto;

import static lotto.constants.Boolean.FALSE;
import static lotto.constants.Boolean.TRUE;

import lotto.domain.Money;
import lotto.domain.User;
import lotto.ui.Input;
import lotto.ui.Output;

public class GameManager {

    public static void handlePurchase() {
        boolean isPurchasing = TRUE.get();
        User user = new User();
        while (isPurchasing) {
            try {
                Output.printPurchase();
                user.purchaseLotto(new Money(Input.get()));
                isPurchasing = FALSE.get();
            } catch (IllegalArgumentException ex) {
                Output.printError(ex);
            }
        }
    }

    public static void main(String[] args) {
        handlePurchase();
    }

}
