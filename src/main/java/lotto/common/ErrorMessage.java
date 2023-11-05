package lotto.common;

public enum ErrorMessage {

    /* 구매 금액 관련 에러 메시지 */
    LOTTO_AMOUNT_IS_NOT_DIVISIBLE("[ERROR] 구입 금액은 1,000원 단위입니다."),
    LOTTO_COUNT_MIN_TICKET_PRICE("[ERROR] 최소 구매 금액보다 적게 입력하였습니다."),
    LOTTO_AMOUNT_NULL("[ERROR] 구입 금액이 입력되지 않았습니다."),
    LOTTO_AMOUNT_CONTAINS_BLANK("[ERROR] 구입 금액은 공백을 포함할 수 없습니다."),

    /* 로또 번호 관련 에러 메시지 */
    LOTTO_NUMBER_RANGE(
            "[ERROR] 로또 번호는 " + Constant.LOTTO_NUMBER_MIN.getIntValue() + "부터 "
                    + Constant.LOTTO_NUMBER_MAX.getIntValue() + " 사이의 숫자여야 합니다."),
    LOTTO_NUMBERS_LENGTH("[ERROR] 로또 번호는 " + Constant.LOTTO_NUMBERS_MAX_LENGTH.getIntValue() + "자리 숫자여야 합니다."),
    LOTTO_NUMBERS_DUPLICATE("[ERROR] 로또 번호는 중복이 불가능합니다."),
    LOTTO_NUMBERS_NULL("[ERROR] 로또 번호는 필수 입력값 입니다."),
    LOTTO_NUMBERS_CONTAINS_BLANK("[ERROR] 로또 번호는 공백을 포함할 수 없습니다."),
    LOTTO_NUMBERS_ENDS_WITH_COMMA("[ERROR] 맨 끝에 쉼표(,)를 포함할 수 없습니다."),


    /* 보너스 번호 관련 에러 메시지 */
    BONUS_NUMBER_IS_NOT_ONE("[ERROR] 보너스 번호는 1개만 입력 가능합니다."),
    BONUS_NUMBER_NULL("[ERROR] 보너스 번호는 필수 입력값 입니다."),
    BONUS_NUMBER_CONTAINS_BLANK("[ERROR] 보너스 번호는 공백을 포함할 수 없습니다."),
    BONUS_NUMBER_DUPLICATE("[ERROR] 잘못된 보너스 번호입니다. 이미 당첨 번호에 포함된 번호입니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get(String... args) {
        return String.format(message, (Object) args);
    }
}
