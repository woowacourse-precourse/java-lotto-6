package lotto.common.util;

public enum OutputMessage {
    START("구입금액을 입력해 주세요."),
    COUNT("개를 구매했습니다."),
    LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
