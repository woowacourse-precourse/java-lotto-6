package domain;

import validators.AmountValidator;

public class UserLotto {

    private int amount;
    private int lottoCount;

    private Lotto lottoNumber;

    private int bonusNumber;

    public UserLotto (String purchasedAmount) throws IllegalArgumentException{
        if(AmountValidator.isVerifyAmount(purchasedAmount)) {
            int amount = Integer.parseInt(purchasedAmount);
            this.amount = amount;
            this.lottoCount = amount/1000;
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
