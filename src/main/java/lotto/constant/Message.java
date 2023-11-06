package lotto.constant;

public enum Message {

    BUYING_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    BOUGHT_QUANTITY_MESSAGE("개를 구매했습니다."),
    INPUT_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    LOTTO_RESULT_MESSAGE("당첨 통계" + "\n" + "---"),
    RATE_OF_RETURN_MESSAGE_HEAD("총 수익률은 "),
    RATE_OF_RETURN_MESSAGE_TAIL("%입니다.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String getRateOfReturnMessage(String rateOfReturn) {
        return RATE_OF_RETURN_MESSAGE_HEAD.getMessage() + rateOfReturn + RATE_OF_RETURN_MESSAGE_TAIL.getMessage();
    }

}
