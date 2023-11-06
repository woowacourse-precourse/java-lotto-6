package lotto.constant;

public enum Announcer {

    PURCHASE_PAYMENT("구입금액을 입력해주세요."),
    LOTTO_NUMBER("당첨 번호를 입력해주세요."),
    LOTTO_BONUS_NUMBER("보너스 번호를 입력해주세요."),
    PURCHASE_COUNT("%d개를 구매했습니다.");

    private final String message;

    Announcer(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
