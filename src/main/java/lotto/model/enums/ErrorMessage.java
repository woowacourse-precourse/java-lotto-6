package lotto.model.enums;

public enum ErrorMessage {
    NUMBERS_SIZE_ERROR_MESSAGE("[ERROR] 로또 번호는 6개의 숫자여야 합니다."),
    NUMBERS_DUPLICATION_ERROR_MESSAGE("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다."),
    NUMBERS_RANGE_ERROR_MESSAGE("[ERROR] 로또 번호는 1과 45사이의 숫자여야 합니다."),
    PRICE_ERROR_MESSAGE("[ERROR] 로또 구입 금액은 1000원 단위의 양수여야 합니다."),
    PRICE_TYPE_ERROR_MESSAGE("[ERROR] 구입 금액은 숫자여야 합니다."),
    PRICE_NEGATIVE_ERROR_MESSAGE("[ERROR] 구입 금액은 양수여야 합니다."),
    BONUS_NUMBER_TYPE_ERROR_MESSAGE("[ERROR] 보너스 번호는 숫자여야 합니다."),
    BONUS_NUMBER_NEGATIVE_ERROR_MESSAGE("[ERROR] 보너스 번호는 양수여야 합니다."),
    BONUS_NUMBER_RANGE_ERROR_MESSAGE("[ERROR] 보너스 번호는 1과 45사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE("[ERROR] 보너스 번호는 중복되지 않는 수만 가능합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
