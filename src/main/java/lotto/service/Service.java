package lotto.service;

import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.utils.LottoAmountValidator;
import lotto.utils.PrizeNumberValidator;
import lotto.view.InputView;

import java.util.List;

public class Service {
    private static final int LOTTO_MIN_AMOUNT = 1000;

    public static int setAmount(String amount) {
        LottoAmountValidator validation = new LottoAmountValidator(amount);
        return validation.amount / LOTTO_MIN_AMOUNT;
    }
    

}

