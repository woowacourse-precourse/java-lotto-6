package lotto.util.message;

public enum ErrorMessage {
    REQUEST_MORE_THAN_MINIMUM_PRICE("1000원 이상의 가격을 입력해주세요"),
    REQUEST_PRICE_STANDARD("1000원 단위의 가격만 입력해주세요"),
    REQUEST_NOT_DUPLICATED("중복된 번호는 사용할 수 없습니다."),
    REQUEST_DELIMITER("쉼표(,)를 이용하여 번호를 구분해주세요."),
    REQUEST_NUMBER_RANGE("1부터 45 사이의 숫자를 입력해주세요"),
    REQUEST_INT_LIST("1부터 45사이의 숫자 6개를 쉼표(,)를 이용하여 구분해 입력해주세요"),
    PREFIX("[ERROR]");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return PREFIX.message + message;
    }
}
