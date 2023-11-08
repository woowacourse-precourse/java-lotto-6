package lotto.domain;

import static lotto.constants.ExceptionMessage.PAY_RANGE_ERROR;

import lotto.constants.GameRule;
import lotto.utils.LottoGameException;

public class User {
    private final int pay;
    private final int lottoCnt;

    public User(String payment) {
        int pay = Integer.parseInt(payment);

        validate(pay);

        this.pay = pay;
        this.lottoCnt = pay/ GameRule.PAY_UNIT;
    }

    public static void validate(int payment) {
        if ((payment % GameRule.PAY_UNIT)!= 0) {
            throw LottoGameException.withMessage(PAY_RANGE_ERROR);
        }
    }

    public static User paid(String pay) {
        return new User(pay);
    }

    public int getLottoCnt() {
        return lottoCnt;
    }
}
