package lotto.message;

public enum ErrorMessage {
    NOT_NUMERIC_EXCEPTION("[ERROR] 로또 구입 금액은 숫자만 입력 가능합니다."),
    MULTIPLE_OF_THOUSAND_EXCEPTION("[ERROR] 로또 구입 금액은 1000원 단위로 입력 가능합니다."),
    THOUSAND_OR_MORE_EXCEPTION("[ERROR] 로또 구입 금액은 1000원 이상만 입력 가능합니다."),
    HAS_BLANK_EXCEPTION("[ERROR] 로또 번호에 공백이 포함되어 있습니다."),
    NOT_COMMA_SEPARATED_EXCEPTION("[ERROR] 로또 번호는 쉼표(,)로 구분한 6개를 입력해야합니다."),
    NOT_ALL_NUMERIC_EXCEPTION("[ERROR] 로또 번호는 숫자만 입력 가능합니다."),
    NOT_IN_RANGE_EXCEPTION("[ERROR] 로또 번호는 1부터 45까지의 숫자만 입력 가능합니다."),
    NOT_UNIQUE_EXCEPTION("[ERROR] 로또 번호는 중복될 수 없습니다."),
    INVALID_SIZE_EXCEPTION("[ERROR] 로또 번호는 6개여야 합니다."),
    NOT_SORTED_EXCEPTION("[ERROR] 로또 번호는 오름차순으로 정렬되어야 합니다.");


    ErrorMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
