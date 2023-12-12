package lotto.model;

import lotto.util.MakeStringToInteger;


public class Purchase {
    private final Integer money;

    public Purchase(String inputPrice){
        validate(inputPrice);
        this.money = Integer.parseInt(inputPrice);
    }

    private void validate(String inputPrice) {
        int validatePrice = MakeStringToInteger.stringToInteger(inputPrice);
        if((validatePrice % 1000 != 0) || (validatePrice <= 0)){
            throw new IllegalArgumentException();
        }
    }

    public Integer getLottoTicketNumber(){
        return money/1000;
    }

    public Integer getMoney(){
        return money;
    }
}
