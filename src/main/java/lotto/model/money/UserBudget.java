package lotto.model.money;

import static lotto.exception.ExceptionMessage.LOTTO_MONEY_OUT_OF_RANGE;
import static lotto.exception.ExceptionMessage.LOTTO_MONEY_UNIT_ERROR;
import static lotto.utils.constant.LottoConstant.LOTTO_MONEY_MAX;
import static lotto.utils.constant.LottoConstant.LOTTO_MONEY_MIN;
import static lotto.utils.constant.LottoConstant.LOTTO_MONEY_UNIT;

public class UserBudget {
    private int budget;
    private final LottoCount lottoCount;

    private UserBudget(int budget) {
        checkBudgetInRange(budget);
        checkBudgetUnit(budget);
        this.budget = budget;
        this.lottoCount = new LottoCount(calculateLottoCount(budget));
    }

    public static UserBudget of(int budget) {
        return new UserBudget(budget);
    }

    private int calculateLottoCount(int budget) {
        return budget / LOTTO_MONEY_UNIT.getValue();
    }

    private void checkBudgetInRange(int budget) {
        if (budget <= LOTTO_MONEY_MIN.getValue() || budget >= LOTTO_MONEY_MAX.getValue()) {
            throw new IllegalArgumentException(LOTTO_MONEY_OUT_OF_RANGE.getMessage());
        }
    }

    private void checkBudgetUnit(int budget) {
        if (budget % LOTTO_MONEY_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(LOTTO_MONEY_UNIT_ERROR.getMessage());
        }
    }
}
