package enums;

public enum Message {

    REQUIRE_PURCHASE_MONEY("구입 금액을 입력해 주세요."),
    REQUIRE_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUIRE_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    PUBLISHED_LOTTO("개를 구매했습니다.");
    private final String message;
    Message(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
