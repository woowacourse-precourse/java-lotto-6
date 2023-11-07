package lotto.model;

import lotto.util.CheckParameter;

public class Purchase {
    private final Integer money;

    public Purchase(String inputPrice){
        validate(inputPrice);
        this.money = Integer.parseInt(inputPrice);
    }

    private void validate(String inputPrice) {
        if(!CheckParameter.checkIsNumber(inputPrice)){
            throw new IllegalArgumentException();
        }

        int validatePrice = Integer.parseInt(inputPrice);
        if((validatePrice % 1000 != 0) || (validatePrice <= 0)){
            throw new IllegalArgumentException();
        }
    }

    public Integer getlottoTicketNumber(){
        return money/1000;
    }

    public Integer getMoney(){
        return money;
    }
}
