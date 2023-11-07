package lotto.constant;

public enum ExceptionConstant {
    NUMBER_RANGE_EXCEPTION("로또 번호는 %d부터 %d 사이의 숫자여야 합니다."
            .formatted(NumberConstant.MIN_NUMBER.getValue(), NumberConstant.MAX_NUMBER.getValue())),
    NUMBER_EXCEPTION("숫자가 입력되야 합니다."),
    BLANK_EXCEPTION("공백이 없어야 합니다."),
    POSITIVE_EXCEPTION("금액은 양수의 숫자여야 합니다."),
    DIVIDE_EXCEPTION("금액은 %d 단위의 숫자여야 합니다."
            .formatted(NumberConstant.LOTTO_PRICE.getValue())),
    NUMBER_LENGTH_EXCEPTION("로또 번호는 6개 숫자여야 합니다."),
    NUMBER_DUPLICATE_EXCEPTION("로또 번호는 중복될 수 없습니다.");

    private final String message;

    ExceptionConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
