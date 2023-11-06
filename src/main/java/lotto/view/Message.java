package lotto.view;

public enum Message {
    REQUEST_MONEY("구입금액을 입력해 주세요."),
    REQUEST_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_NUMBER_BONUS("보너스 번호를 입력해 주세요."),

    RESPONSE_CART("%d개를 구매했습니다."),
    RESPONSE_NUMBERS("[%s]"),
    RESPONSE_FINAL_TITLE("당첨 통계\n---"),
    RESPONSE_MATCHED("%d개 일치%s ($s원) - %d개"),
    RESPONSE_PNL("총 수익률은 %.1f%%입니다.");

    private final String content;

    Message(String message) {
        this.content = message;
    }

    public String getMessage() {
        return content;
    }

    public String getMessage(Object... args) {
        return String.format(content, args);
    }
}
