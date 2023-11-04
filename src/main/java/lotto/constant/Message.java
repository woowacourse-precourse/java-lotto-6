package lotto.constant;

public enum Message {

    BUYING_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    BOUGHT_QUANTITY_MESSAGE("개를 구매했습니다."),
    INPUT_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    LOTTO_RESULT_MESSAGE("당첨 통계" + "\n" + "---");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
