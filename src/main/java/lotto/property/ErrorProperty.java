package lotto.property;

public enum ErrorProperty {
    VALUE_IS_EMPTY("입력 값이 공백입니다");

    private String errorMessage;

    ErrorProperty(String errorMessage) {
        this.errorMessage = errorPrefix+errorMessage;
    }

    static final String errorPrefix="[ERROR] ";

    @Override
    public String toString() {
        return errorMessage;
    }
}
