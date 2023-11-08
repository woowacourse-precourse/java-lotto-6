package lotto.constant.response;

public enum Exception {
    ERROR_PREFIX("[ERROR]"),
    MONEY_NULL_BLANK("로또 구입 금액을 입력해야 합니다."),
    MONEY_NUMERIC("로또 구입 금액은 숫자로만 이루어져야 합니다."),
    WINNING_NUMBERS_NULL_BLANK("당첨 번호를 입력해야 합니다."),
    WINNING_NUMBERS_NUMERIC("당첨 번호는 숫자로만 이루어져야 합니다."),
    BONUS_NUMBER_NULL_BLANK("보너스 번호를 입력해야 합니다."),
    BONUS_NUMBER_NUMERIC("보너스 번호는 숫자로만 이루어져야 합니다."),
    LOTTO_SIZE("로또는 6개의 번호를 가져야 합니다."),
    LOTTO_DUPLICATE("로또는 중복되지 않는 수로 이루어져야 합니다."),
    LOTTO_NUMBER_RANGE("로또 번호의 숫자 범위는 1~45까지 입니다."),
    LOTTO_PRICE("구입 금액은 1,000원 단위로 이루어 져야 합니다."),
    WINNING_NUMBERS_DUPLICATE("로또 번호 6개와 보너스 번호는 중복될 수 없습니다.");


    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
