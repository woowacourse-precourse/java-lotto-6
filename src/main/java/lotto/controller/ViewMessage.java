package lotto.controller;

public enum ViewMessage {
    InputUserPrice("구입금액을 입력해 주세요."),
    OutputPurchasesNumber("개를 구매했습니다."),
    ErrorInvaildPrice("[ERROR] 유효하지 않는 금액입니다.");

    public final String message;
    ViewMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
