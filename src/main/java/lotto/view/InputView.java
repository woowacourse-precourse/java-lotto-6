package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseBudget;

import static lotto.constants.InputMessage.*;
import static lotto.util.InputUtils.*;

public class InputView {

    public static PurchaseBudget getPurchaseBudget() {
        try {
            println(DEMAND_INPUT_BUDGET.getMessage());
            return new PurchaseBudget(readInt());
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
            return getPurchaseBudget();
        }
    }

    public static Lotto getWinningLotto() {
        try {
            println(DEMAND_INPUT_WINNING_NUMBERS.getMessage());
            return new Lotto(readLottoNumbers());
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
            return getWinningLotto();
        }
    }

    public static LottoNumber getBonusLottoNumber(Lotto winningLotto) {
        try {
            println(DEMAND_INPUT_BONUS_NUMBER.getMessage());
            return readBonusNumber(winningLotto);
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
            return getBonusLottoNumber(winningLotto);
        }
    }

    public static void println(String message) {
        System.out.println(message);
    }
}
