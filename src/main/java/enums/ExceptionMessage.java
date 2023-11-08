package enums;

public enum ExceptionMessage {
    ILLIGAL_COST_ERROR_MESSAGE("[ERROR] 잘못된 로또 금액 입니다."),
    ILLIGAL_WINNING_NUM_MESSAGE("[ERROR] 잘못된 당첨 번호 입니다."),
    ILLIGAL_BONUS_NUM_MESSAGE("[ERROR] 잘못된 보너스 번호 입니다."),
    DUPLICATE_NUMBER_MESSAGE("[ERROR] 중복된 로또 번호 입니다.");

    private final String exceptMessage;

    ExceptionMessage(String message) {
        this.exceptMessage = message;
    }

    public String getMessage() {
        return exceptMessage;
    }
}
