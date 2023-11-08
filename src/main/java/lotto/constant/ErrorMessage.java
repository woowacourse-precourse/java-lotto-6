package lotto.constant;

public enum ErrorMessage {

    ERROR_RANGE("[ERROR]", "로또 번호는 1부터 45 사이의 6개의 숫자만 입력하셔야 합니다."),
    ERROR_PRICE("[ERROR]", "금액은 1000원 단위로만 입력해주세요"),
    ERROR_BONUS("[ERROR]", "보너스 번호는 당첨번호와 겹치지 않는 1~45사이의 양수로만 입력해주세요");

    private final String error;
    private final String message;

    ErrorMessage(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getMessage() {
        return String.format("%s %s", error, message);
    }

}
