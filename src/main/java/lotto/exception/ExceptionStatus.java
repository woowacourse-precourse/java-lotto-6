package lotto.exception;

public enum ExceptionStatus {
    // 공통 사용자 입력 예외
    INPUT_COMMON_NOT_A_NUMBER("입력 값은 양의 정수만 허용됩니다."),


    //  구매금액 입력 예외
    PURCHASE_PRICE_EMPTY("구입 금액이 입력되지 않았습니다."),
    PURCHASE_PRICE_NOT_DIVIDED("구입 금액은 1000원 단위로 나누어 떨어져야 합니다."),

    //    로또 번호 공통
    LOTTO_COMMON_OUT_OF_RANGE("로또의 번호는 1~45 사이 숫자여야 합니다."),
    LOTTO_COMMON_INVALID_SIZE("로또는 6자리 입력만 가능합니다."),
    LOTTO_COMMON_DUPLICATE("로또 번호는 중복될 수 없습니다."),
    LOTTO_COMMON_EMPTY("로또 번호가 없습니다."),

    //  당첨번호 예외
    WINNING_NUMBER_EMPTY("당첨 번호가 입력되지 않았습니다."),
    WINNING_NUMBER_INVALID("당첨번호는 6자리의 수를 , 로 구분해서 입력해야합니다."),

    //  보너스 예외
    BONUS_NUMBER_INVALID("보너스 번호는 1 ~ 45 숫자만 입력 가능합니다."),
    BONUS_NUMBER_EMPTY("보너스 번호가 입력되지 않았습니다."),

    ;

    private final String message;
    private final static String HEADER = "[ERROR] ";

    ExceptionStatus(String message) {
        this.message = HEADER + message;
    }

    public String getMessage() {
        return this.message;
    }
}
