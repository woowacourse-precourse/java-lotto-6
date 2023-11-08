package lotto.global.error;

public enum ErrorMessage {
    PRICE_NOT_INTEGER("[ERROR] 가격은 숫자만 가능합니다."),
    PRICE_MISMATCH("[ERROR] 가격은 1,000원 단위의 숫자만 가능합니다."),
    NUMBER_IS_BLANK("[ERROR] 당첨 번호는 공백일 수 없습니다."),
    NUMBER_NOT_CONTAIN_SYMBOL("[ERROR] 당첨 번호는 쉼표(,)를 포함해야 합니다."),
    NUMBER_INVALID_SYMBOL_POSITION("[ERROR] 당첨 번호의 쉼표(,) 위치가 적절하지 않습니다."),
    NUMBER_INVALID_COUNT("[ERROR] 당첨 번호는 6개를 입력해야 합니다."),
    NUMBER_INVALID_RANGE("[ERROR] 당첨 번호는 1 ~ 45 사이의 숫자만 가능합니다."),
    NUMBER_NOT_INTEGER("[ERROR] 당첨 번호는 숫자만 가능합니다."),
    NUMBER_DUPLICATE("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    BONUS_NUMBER_INVALID_RANGE("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자만 가능합니다."),
    BONUS_NUMBER_NOT_INTEGER("[ERROR] 보너스 번호는 숫자만 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}