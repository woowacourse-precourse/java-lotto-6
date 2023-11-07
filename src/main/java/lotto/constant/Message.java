package lotto.constant;

public enum Message {
    INPUT_PURCHASE("구입 금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASE_COUNT("개를 구매했습니다."),

    // 당첨 통계
    WINNING_STATISTICS("당첨 통계"),
    WINNING_LINE_BREAK("---"),
    INFOR_SEPARATOR(" - "),
    MATCHED_LOTTO_NUMBER_UNITS("개"),
    RATE_OF_RETURN_SUBJECT("총 수익률은 "),
    RATE_OF_RETURN_UNITS("%"),
    RATE_OF_RETURN_VERB("입니다."),
    LINE_BREAK("\n");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
