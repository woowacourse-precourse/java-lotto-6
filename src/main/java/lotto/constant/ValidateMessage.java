package lotto.constant;

public enum ValidateMessage {
    PURCHASE_PRICE_CANNOT_BE_NULL_OR_EMPTY("구입 금액은 null 값이거나 빈 값 일 수 없습니다."),
    PURCHASE_PRICE_IS_NOT_INTEGER("구입 금액은 정수 값으로 입력해주세요."),
    PURCHASE_PRICE_IS_NOT_DIVIDED_1000("구입 금액은 1,000원 단위로 입력해주세요."),
    PURCHASE_PRICE_CAN_NOT_BE_0("구입 금액은 0원 이상으로 입력해주세요."),

    WINNER_NUMBER_CANNOT_BE_NULL_OR_EMPTY("당첨 숫자는 null 값이거나 빈 값 일 수 없습니다."),
    WINNER_NUMBER_VALIDATE_ERROR_INPUT("잘못된 입력 방법입니다. 올바른 입력 예시 : 1,2,3,4,5,6"),
    WINNER_NUMBER_IS_NOT_INTEGER("당첨 숫자는 1 ~ 45 사이 숫자를 입력해주셔야 합니다. 올바른 입력 예시 : 1,2,3,4,5,6"),
    WINNER_NUMBER_IS_NOT_SIZE_EQUAL_TO_SIX("당첨 숫자는 6개여야 입력해야 합니다."),
    WINNER_NUMBER_IS_BETWEEN_1_TO_45("당첨 숫자는 1 ~ 45 사이 숫자여야 합니다."),
    WINNER_NUMBER_IS_DUPLICATE("당첨 숫자는 서로 중복되면 안됩니다."),


    BONUS_NUMBER_CANNOT_BE_NULL_OR_EMPTY("보너스 숫자는 null 값이거나 빈 값 일 수 없습니다."),
    BONUS_NUMBER_IS_NOT_INTEGER("보너스 숫자는 정수 값으로 입력해주세요."),
    BONUS_NUMBER_IS_BETWEEN_1_TO_45("보너스 숫자는 1 ~ 45 사이 숫자여야 합니다."),
    BONUS_NUMBER_IS_DUPLICATE("보너스 숫자는 당첨 번호와 서로 중복되면 안됩니다."),

    LOTTO_NUMBER_IS_NOT_SIZE_EQUAL_TO_SIX("로또 번호는 6개여야 입력해야 합니다."),
    LOTTO_NUMBER_IS_BETWEEN_1_TO_45("로또 번호는 1 ~ 45 사이 숫자여야 합니다."),
    LOTTO_NUMBER_IS_DUPLICATE("로또 번호는 서로 중복되면 안됩니다.");


    private static final String errorMessage = "[ERROR] ";
    public final String message;

    ValidateMessage(String message) {
        this.message = message;
    }

    public void throwException() {
        throw new IllegalArgumentException(errorMessage + message);
    }
}
