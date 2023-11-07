package lotto.constant;

public enum ErrorMessage {
    PREFIX("[ERROR] %s"),

    INDIVISIBLE_AMOUNT(String.format(
            "%,d원 단위의 금액을 입력해야 합니다.",
            Constants.LOTTO_PRICE
    )),
    OUT_RANGE_AMOUNT(String.format(
            "%,d원 이상, %,d원 이하의 금액을 입력해야 합니다.",
            Constants.MIN_AMOUNT,
            Constants.MAX_AMOUNT
    )),

    INVALID_LOTTO_NUMBERS_SIZE(String.format(
            "로또 번호의 개수는 %d개 여야 합니다.",
            Constants.LOTTO_NUMBER_COUNT
    )),
    OUT_RANGE_LOTTO_NUMBER(String.format(
            "로또 숫자는 %d 이상 %d 이하여야 합니다.",
            Constants.MIN_LOTTO_NUMBER,
            Constants.MAX_LOTTO_NUMBER
    )),
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다."),

    BONUS_NUMBER_ALREADY_INITIALIZED("보너스 번호는 한 번만 초기화할 수 있습니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 로또 번호와 중복될 수 없습니다."),

    INVALID_LONG_FORMAT(String.format(
            "%,d 이상 %,d 이하의 숫자만 입력 가능합니다.",
            Long.MIN_VALUE,
            Long.MAX_VALUE
    )),
    INVALID_INTEGER_FORMAT(String.format(
            "%,d 이상 %,d 이하의 숫자만 입력 가능합니다.",
            Integer.MIN_VALUE,
            Integer.MAX_VALUE
    )),
    INVALID_MULTIPLE_INTEGER_FORMAT(String.format(
            "%,d 이상 %,d 이하의 ','로 구분된 숫자들만 입력 가능합니다.",
            Integer.MIN_VALUE,
            Integer.MAX_VALUE
    )),
    ;
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(PREFIX.message, this.message);
    }
}