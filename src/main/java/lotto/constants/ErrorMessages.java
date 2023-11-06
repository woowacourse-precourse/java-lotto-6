package lotto.constants;

public enum ErrorMessages {
    ERROR_HEADER("[ERROR] "),
    BUY_EMPTY_ERROR("구입 금액을 입력해야 합니다."),
    BUY_CHAR_ERROR("구입 금액은 쉼표(,) 없이 숫자로 입력해야 합니다."),
    BUY_MINUS_ERROR("구입 금액은 음수가 될 수 없습니다."),
    BUY_CONDITION_ERROR("구입 금액은 1,000원 담위로 입력해야 합니다."),
    LOTTO_EMPTY_ERROR("당첨 번호를 입력해야 합니다."),
    LOTTO_CHAR_ERROR("당첨 번호는 쉼표(,)를 기준으로 숫자로 입력해야 합니다."),
    LOTTO_RANGE_ERROR("로또 번호는 1부터 45사이의 숫자여야 합니다."),
    LOTTO_LENGTH_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_DUPLICATE_ERROR("로또 번호는 중복될 수 없습니다."),
    BONUS_EMPTY_ERROR("보너스 번호를 입력해야 합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
