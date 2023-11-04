package lotto.constant.message;

public enum ExceptionMessage {
    ERROR("[ERROR] "),

    IS_NOT_NUMBER(ERROR + "숫자를 입력해주세요"),
    // 1000 다른 값으로 대체하기
    PURCHASE_ERROR(ERROR + "구매 금액은 "+"1000"+"으로 나누어 떨어져야 합니다."),

    // 6
    COUNT_ERROR("당첨 번호는 "+"6"+"개를 입력해야 합니다."),
    NUMBER_BLANK("당첨 번호는 ,(쉼표)로 구분하여 입력해야 하며, 공백을 포함할 수 없습니다."),
    NUMBER_DUPLICATE(ERROR + "당첨 번호는 중복될 수 없습니다."),
    // 1, 45
    NUMBER_RANGE(ERROR + "로또 번호는 " + "1" + "부터 " + "45" + " 사이의 숫자여야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}