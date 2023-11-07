package lotto.global.common;

public enum NoticeMessage {
    PURCHASE_QUANTITY("개를 구매했습니다."),
    WINNING_STATICS("당첨 통계"),
    THREE_HYPHENS("---");

    private String message;

    private NoticeMessage() {}

    private NoticeMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
