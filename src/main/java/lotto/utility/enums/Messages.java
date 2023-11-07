package lotto.utility.enums;

public enum Messages {
    INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요.");

    private String message;

    Messages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
