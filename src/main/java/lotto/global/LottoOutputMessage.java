package lotto.global;

public enum LottoOutputMessage {

    PURCHASED_LOTTO_COUNT("개를 구매했습니다."),
    LOTTO_RESULT("당첨 통계\n---\n"),
    ;

    private final String message;

    LottoOutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
