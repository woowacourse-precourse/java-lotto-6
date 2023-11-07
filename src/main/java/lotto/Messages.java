package lotto;

public enum Messages {
    PURCHASE_PROMPT("구입금액을 입력해 주세요."),
    WIN_NUMBER_PROMPT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_PROMPT("보너스 번호를 입력해 주세요."),

    ALL_NUMBER_ERROR("[ERROR] 올바른 숫자를 입력해 주세요.\n"),
    DIVISIBLE_BY_THOUSAND_ERROR("[ERROR] 구입 금액은 1,000원 단위여야 합니다.\n"),
    BETWEEN_RANGE_ERROR("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.\n"),
    DUPLICATED_ERROR("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.\n");

    private final String message;
    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
