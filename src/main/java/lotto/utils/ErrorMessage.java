package lotto.utils;

public enum ErrorMessage {
    LOTTO_PURCHASE_AMOUNT_DIVIDE_REST_EXCEPTION_MESSAGE("로또 구입 금액은 1,000원으로 나누어 떨어져야합니다."),
    LOTTO_PURCHASE_AMOUNT_NOT_DIGIT_EXCEPTION_MESSAGE("로또 구입 금액은 숫자여야합니다."),
    LOTTO_WINNING_NUMBERS_SIZE_EXCEPTION_MESSAGE("로또 당첨 번호의 개수는 6개여야합니다."),
    LOTTO_WINNING_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE("로또 당첨 번호는 중복될 수 없습니다."),
    LOTTO_WINNING_NUMBERS_RANGE_EXCEPTION_MESSAGE("로또 당첨 번호의 범위는 1~45여야합니다."),
    LOTTO_WINNING_NUMBERS_TYPE_EXCEPTION_MESSAGE("로또 당첨 번호는 공백 없이 쉼표로 구분된 숫자여야합니다."),
    BONUS_NUMBER_NOT_DIGIT_EXCEPTION_MESSAGE("보너스 번호는 숫자여야합니다."),
    BONUS_NUMBER_RANGE_EXCEPTION_MESSAGE("보너스 번호의 범위는 1~45여야합니다."),
    BONUS_NUMBER_WINNING_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE("보너스 번호는 당첨 번호에 있는 번호를 제외한 번호여야합니다."),
    NUMBERS_SIZE_NOT_SIX_EXCEPTION_MESSAGE("발행 로또 번호의 개수는 6개여야합니다."),
    NUMBERS_DUPLICATE_EXCEPTION_MESSAGE("발행 로또 번호는 중복될 수 없습니다."),
    NUMBERS_WRONG_RANGE_EXCEPTION_MESSAGE("발행 로또 번호는 1~45의 범위여야합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
