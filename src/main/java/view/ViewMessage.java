package view;

public enum ViewMessage {

    INPUT_PRICE("구입금액을 입력해 주세요."),
    INPUT_PRIZE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS("보너스 번호를 입력해 주세요."),
    PURCHASE_RESULT("개를 구매했습니다."),
    RESULT("당첨 통계"),
    SEPERATE("---"),
    TAB("");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
