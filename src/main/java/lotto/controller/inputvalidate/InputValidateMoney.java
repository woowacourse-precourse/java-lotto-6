package lotto.controller.inputvalidate;

import lotto.repository.Repository;

public class InputValidateMoney extends InputValidate{

    public int lottoCountValidate(String amount){
        try {
            return validateCount(amount);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private int validateCount(String amount) throws IllegalArgumentException{
        int money = super.validateIsDigit(amount);
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액 형식이 1000원 단위가 아닙니다.");
        }
        return money/1000;
    }
}
