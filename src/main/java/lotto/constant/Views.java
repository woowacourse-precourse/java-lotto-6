package lotto.constant;

public enum Views {
    PURCHASE_AMOUT_MESSAGE("구입금액을 입력해 주세요.");

    private final String message;

    Views(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
