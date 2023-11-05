package lotto.view.constants;

public enum ConstantMessage {
    ASK_LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요.");

    private final String message;

    ConstantMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
