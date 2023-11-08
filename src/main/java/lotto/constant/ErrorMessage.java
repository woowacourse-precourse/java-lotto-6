package lotto.constant;

public enum ErrorMessage {
    NUMBERS_SIZE("로또 번호는 " + Constant.NUMBERS_SIZE + "개여야 합니다."),
    OUT_OF_RANGE(
            "로또 번호는 " + Constant.MIN_NUMBER + "~" + Constant.MAX_NUMBER + " 사이의 수여야 합니다."),
    DUPLICATE("로또 번호는 서로 다른 수여야 합니다."),

    LOTTO_SIZE("복권을 1개 이상 구매해야 합니다."),

    NON_INTEGER("정수를 입력해야 합니다."),

    NOT_DIVISIBLE(Constant.LOTTO_PRICE + "배수인 정수를 입력 해야 합니다.");

    public final String prefix = "[ERROR] ";
    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
