package lotto;

import static lotto.constants.Boolean.FALSE;
import static lotto.constants.Boolean.TRUE;

import lotto.domain.Money;
import lotto.domain.User;

public class GameManager {

    public static void handlePurchase(String userInput) {
        boolean isPurchasing = TRUE.get();
        User user = new User();

        while (isPurchasing) {
            try {
                user.purchaseLotto(new Money(userInput));
                isPurchasing = FALSE.get();
            } catch (IllegalArgumentException ex) {

            }
        }
    }

}
