package domain;

import validators.AmountValidator;

public class UserLotto {

    private int amount;

    private Lotto lottoNumber;

    private int bonusNumber;

    public UserLotto (String purchasedAmount){
        if(!AmountValidator.isVerifyAmount(purchasedAmount)) {
            throw new IllegalArgumentException();
        }
        this.amount = Integer.parseInt(purchasedAmount);
    }

}
