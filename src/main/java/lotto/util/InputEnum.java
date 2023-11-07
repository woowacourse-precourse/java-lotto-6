package lotto.util;

public enum InputEnum{

    PURCHASE_AMOUNT_INPUT("구입 금액을 입력해주세요.");

    private String message;

    InputEnum(String message){
        this.message = message;
    }

    public String message(){
        return this.message;
    }


}
