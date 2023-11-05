package domain;

import validators.AmountValidator;

public class UserLotto {

    private int amount;

    private Lotto lottoNumber;

    private int bonusNumber;

    public UserLotto (String purchasedAmount) throws IllegalArgumentException{
        if(AmountValidator.isVerifyAmount(purchasedAmount)) {
            this.amount = Integer.parseInt(purchasedAmount);
        }
    }

}
