package lotto.domain;

public enum DomainError {
    LOTTO_SIZE_ERROR("[ERROR] 당첨 번호는 6개여야 합니다. 다시 입력해주세요."),
    LOTTO_DUPLICATE_ERROR("[ERROR] 당첨 번호는 중복할 수 없습니다. 다시 입력해주세요."),
    LOTTO_RANGE_ERROR("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다. 다시 입력해주세요."),
    BONUS_DUPLICATE_ERROR("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다. 다시 입력해주세요."),
    PRICE_ERROR("[ERROR] 로또는 장당 1000원 입니다. 다시 입력해주세요.");

    private final String message;

    DomainError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
