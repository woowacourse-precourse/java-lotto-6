package lotto.util;

public enum InputEnum{

    PURCHASE_AMOUNT_INPUT("구입 금액을 입력해주세요."),
    WINNING_NUMBERS_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요.");

    private String message;

    InputEnum(String message){
        this.message = message;
    }

    public String message(){
        return this.message;
    }


}
