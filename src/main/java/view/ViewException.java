package view;

public enum ViewException {
    INPUT_SHOULD_BE_NUMBER("숫자(양의 정수)를 입력해야 합니다."),
    INPUT_SHOULD_BE_POSITIVE("금액은 0원 이상이어야 합니다."),
    INPUT_SHOULD_BE_OVER_THOUSAND("최소 입력 금액은 1000원 입니다."),
    INPUT_SHOULD_BE_LOWER_THAN_INT_MAX("21억원 이상 구매할 수 없습니다."),
    INPUT_MUST_CONTAINS_COMMA_SEP("번호는 컴마(,)를 통해 구분하여 입력해야 합니다.");

    ViewException(String message){ this.message = message; }
    private final String message;

    public String getMessage() { return message; }
}
