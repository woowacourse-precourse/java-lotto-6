package lotto.message;

public enum GuideMessage {
    GET_PAYMENT_REQUEST_MESSAGE("구입금액을 입력해 주세요."),
    SHOW_LOTTOS_INFO_MESSAGE("%d개를 구매했습니다.");

    private String content;

    GuideMessage(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.content;
    }
}
