package enums;

public enum ErrorMessageEnums {
    NAN_ERROR("[ERROR] 숫자만 입력 가능합니다."),
    OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    TOO_MANY_NUMBERS("[ERROR] 로또 번호는 6개의 숫자여야 합니다."),
    NOT_THOUSAND("[ERROR] 구입 금액은 1000원 단위만 가능합니다.");


    private final String text;

    ErrorMessageEnums(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
