package lotto.controller;

public enum ViewMessage {
    SetPurchaseMoney("구입금액을 입력해 주세요."),
    ErrorInvaildPrice("[ERROR] 유효하지 않는 금액입니다.");

    public final String message;
    ViewMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
