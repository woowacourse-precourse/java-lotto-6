package lotto.service;

import lotto.domain.Buyer;
import lotto.utils.InputUtil;
import lotto.validation.Validation;

public class LottoService {

    public Buyer purchaseLotto() {
        try {
            return new Buyer(lottoPayment());
        } catch (IllegalArgumentException e) {
            return purchaseLotto();
        }
    }

    private Long lottoPayment() {
        return Long.parseLong(amountValidation(InputUtil.inputStringWithTrim()));
    }

    private String amountValidation(String amount) {
        Validation.checkIsNumber(amount);
        Validation.checkIsNatural(Integer.parseInt(amount));
        Validation.checkIsDivideByThousand(amount);
        return amount;
    }
}
