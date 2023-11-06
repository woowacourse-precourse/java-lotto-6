package lotto.controller;

import lotto.model.UserAmount;
import lotto.validation.ValidationUtils;
import lotto.view.LottoView;

public class LottoController {
    private LottoView lottoView;
    private ValidationUtils validationUtils;

    public LottoController() {
        lottoView = new LottoView();
        validationUtils = new ValidationUtils();
    }

    public void startLotto() {
        int money = lottoView.inputMoney();
        boolean isValid = validationUtils.validateUserAmount(money);

        while(!isValid) {
            money = lottoView.inputMoney();
            isValid = validationUtils.validateUserAmount(money);
        }

        UserAmount userAmount = new UserAmount(money);
    }

}
