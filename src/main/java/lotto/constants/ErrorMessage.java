package lotto.constants;

public enum ErrorMessage {
    PAY_MONEY_UNIT("[ERROR] 구입 금액은 1000원 단위로 입력해주세요."),
    PAY_MONEY_RANGE("[ERROR] 구입 금액은 1,000원 이상 2,147,483,000원 이하로 입력해주세요."),
    PAY_MONEY_FORMAT("[ERROR] 구입 금액은 숫자로 입력해주세요."),

    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 값으로 입력해주세요."),
    BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자로 입력해주세요."),

    TYPE_FORMAT("[ERROR] 숫자를 입력해주세요."),

    WINNING_NUMBER_DUPLICATE("[ERROR] 당첨 번호는 중복되지 않게 입력해주세요."),
    WINNING_NUMBER_SIZE("[ERROR] 당첨 번호는 쉼표(,)로 구분하여 6개를 입력해주세요."),
    WINNING_NUMBER_RANGE("[ERROR] 당첨 번호는 1 ~ 45 사이의 숫자로 입력해주세요."),
    WINNING_NUMBER_FORMAT("[ERROR] 당첨 번호는 1 ~ 45 사이의 숫자 6개를 쉼표(,)로 구분하여 입력해주세요.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
