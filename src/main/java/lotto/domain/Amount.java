package lotto.domain;

import lotto.utils.StringUtils;
import lotto.utils.constant.Constant;
import lotto.utils.constant.LottoConstant;
import lotto.utils.message.ErrorMessage;
import lotto.validation.AmountValidation;

public class Amount {
    private final int money;

    public Amount(String money) {
        int m = StringUtils.convertToInt(money);
        new AmountValidation().validate(m);
        this.money = m;
    }

    public int getLottoCount() {
        return money / LottoConstant.LOTTO_AMOUNT;
    }

    public double calculateYield(int price) {
        return Constant.PERCENT * price / money;
    }
}
