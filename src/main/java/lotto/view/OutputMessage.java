package lotto.validator;

public enum OutputMessage {
    PURCHASE_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_INTRODUCE_MESSAGE("개를 구매했습니다."),
    
    ;
    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getIntroduceMessage(int num){
        String sNum=Integer.toString(num);
        return sNum+PURCHASE_INTRODUCE_MESSAGE;
    }
}
