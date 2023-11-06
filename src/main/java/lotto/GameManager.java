package lotto;

import static lotto.constants.Boolean.FALSE;
import static lotto.constants.Boolean.TRUE;
import static lotto.constants.Null.NULL;
import static lotto.constants.Value.INITIAL_ZERO;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoManager;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.User;
import lotto.ui.Input;
import lotto.ui.Output;

public class GameManager {
    private static User user = new User();
    private static Lotto winningLotto;
    private static Integer bonusNumber;

    public static void run() {
        handlePurchase();
        Output.printLottos(user.lottos);

        winningLotto = handleWinningLotto();
        bonusNumber = handleBonusNumber(winningLotto);

        LottoResult lottoResult = LottoManager.checkWinning(user.lottos, winningLotto, bonusNumber);
        Output.printResult(lottoResult, lottoResult.calculateEarningsRate(user.lottoCount));
    }

    private static void handlePurchase() {
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

    private static Lotto handleWinningLotto() {
        boolean isCreating = TRUE.get();
        Lotto winningLotto = NULL.get();
        Output.printWinningNumber();

        while (isCreating) {
            try {
                winningLotto = LottoGenerator.createWinningLotto(Input.get());
                isCreating = FALSE.get();
            } catch (IllegalArgumentException ex) {
                Output.printError(ex);
            }
        }

        return winningLotto;
    }

    private static Integer handleBonusNumber(Lotto winningLotto) {
        boolean isRunning = TRUE.get();
        Integer bonusNumber = INITIAL_ZERO.get();
        Output.printBonusNumber();

        while (isRunning) {
            try {
                bonusNumber = LottoGenerator.createBonusNumber(winningLotto, Input.get());
                isRunning = FALSE.get();
            } catch (IllegalArgumentException ex) {
                Output.printError(ex);
            }
        }

        return bonusNumber;
    }
}
