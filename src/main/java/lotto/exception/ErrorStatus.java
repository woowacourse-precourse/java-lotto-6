package lotto.exception;

public enum ErrorStatus {
    POSITIVE_INTEGER_FORMAT_ERROR("양의 정수만 입력 가능합니다."),
    MONEY_UNIT_ERROR("금액은 1000원 단위로 입력 가능합니다."),
    MONEY_RANGE_ERROR("금액은 1000원 이상이어야 합니다."),
    LOTTO_SIZE_ERROR("로또 번호는 6개입니다."),
    LOTTO_NUMBER_FORMAT_ERROR("로또 번호는 공백 없이 숫자를 쉼표로 구분해 입력 가능합니다. (예시) 1,2,3,4,5,6"),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 1부터 45까지의 숫자만 입력 가능합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("로또 번호는 중복될 수 없습니다."),
    BONUS_NUMBER_RANGE_ERROR("보너스 번호는 1부터 45까지의 숫자만 입력 가능합니다."),
    BONUS_NUMBER_DUPLICATE_ERROR("입력 하신 보너스 번호 당첨 번호에 포함되어 있습니다.");

    private final String message;

    ErrorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
