package lotto.util;

public enum ExceptionMessage {
    COMMON_INVALID_TYPE("[ERROR] 숫자만 입력해주세요."),
    COMMON_INVALID_RANGE("[ERROR] %d에서 %d사이의 숫자로 입력해주세요."),
    PURCHASE_INVALID_TYPE("[ERROR] 숫자로만 입력해주세요. 예시) 1000 or 2000 .."),
    PURCHASE_INVALID_UNIT("[ERROR] 구매 금액은 %d단위로 입력해주세요."),
    PURCHASE_INVALID_NUMBER("[ERROR] 구매 금액은 양수이고, 1000단위로 입력해주세요."),
    MATCHING_COUNT_INVALID("[ERROR] 당첨번호와 로또번호가 동일한 최대 갯수는 6개입니다. 현재 6개를 초과했습니다."),
    WINNING_NUMBER_INVALID_DELIMITER("[ERROR] 쉼표로 구분하여 입력해주세요."),
    WINNING_NUMBER_INVALID_SIZE("[ERROR] 서로 다른 %d개의 당첨 번호를 입력해주세요."),
    BONUS_ALREADY_CONTAIN_WINNING("[ERROR] 당첨 번호에 포함되지 않는 번호를 입력해주세요."),
    TICKET_COUNT_INVALID_NUMBER("[ERROR] 구매 갯수는 최소 1개 이상이어야 합니다."),
    TICKET_COUNT_IS_NULL("[ERROR] 구매 갯수는 null일 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }

}
