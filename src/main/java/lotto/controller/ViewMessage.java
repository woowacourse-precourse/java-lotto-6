package lotto.controller;

public enum ViewMessage {
    SetBuyMoney("구입금액을 입력해 주세요.")
    ;
    public final String message;
    ViewMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
