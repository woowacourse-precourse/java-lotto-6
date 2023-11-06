package lotto;

import static lotto.constants.Boolean.FALSE;
import static lotto.constants.Boolean.TRUE;
import static lotto.constants.Null.NULL;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Money;
import lotto.domain.User;
import lotto.ui.Input;
import lotto.ui.Output;

public class GameManager {
    static User user = new User();
    public static void handlePurchase() {
        boolean isPurchasing = TRUE.get();
        Output.printPurchase();

        while (isPurchasing) {
            try {
                user.purchaseLotto(new Money(Input.get()));
                isPurchasing = FALSE.get();
            } catch (IllegalArgumentException ex) {
                Output.printError(ex);
            }
        }

        Output.printCount(user.lottoCount);
    }

    public static Lotto handleWinningLotto() {
        boolean isCreating = TRUE.get();
        Lotto winningLotto = NULL.get();
        Output.printWinningNumber();

        while (isCreating) {
            try {
                LottoGenerator.createWinningLotto(Input.get());
                isCreating = FALSE.get();
            } catch (IllegalArgumentException ex) {
                Output.printError(ex);
            }
        }

        return winningLotto;
    }

    public static void main(String[] args) {
        handlePurchase();
        Output.printLottos(user.lottos);

        handleWinningLotto();
    }

}
