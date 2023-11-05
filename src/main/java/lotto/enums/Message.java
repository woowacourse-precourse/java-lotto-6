package lotto.enums;

public enum Message {
    AMOUNT_INPUT("구입금액을 입력해 주세요."),
    NUMBERS_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_INPUT("보너스 번호를 입력해 주세요."),
    RESULT("당첨 통계"),
    INVALID_INPUT("[ERROR] 잘못된 금액을 입력하셨습니다."),
    INVALID_AMOUNT("[ERROR] 금액은 1000원 단위로 입력해야 합니다."),
    OUT_OF_RANGE("[ERROR] 금액은 1000원 이상만 입력 가능 합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
