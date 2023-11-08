package lotto.view;

public enum OutputMessage {
    PURCHASE_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_INTRODUCE_MESSAGE("개를 구매했습니다."),
    GET_LOTTO_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요,"),
    RESULT_MESSAGE("당첨 통계\n---"),
    GET_NEXT_LINE("\n");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }

    public String getIntroduceMessage(int num){
        String sNum=Integer.toString(num);
        return GET_NEXT_LINE+sNum+PURCHASE_INTRODUCE_MESSAGE;
    }
}
