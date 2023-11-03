package lotto.domain;

import lotto.validator.LottoValidator;

public class AmountLotto {
    private static final int lottoAmount = 1000;
    private int amount;

    public AmountLotto(){
    }

    public void responseAmountLotto(String amount){
        LottoValidator.amountInputValidator(amount);
        this.amount = Integer.parseInt(amount);
    }

    public int getAmount() {
        return amount;
    }

    public int calculateAmountLotto(){
        return amount / lottoAmount;
    }
}
