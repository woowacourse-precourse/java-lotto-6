package lotto.constant;

public enum ErrorMessage {
    ERROR_MESSAGE("[ERROR]"),
    INPUTCONTAINNOTNUMBER(" 입력에 숫자가 아닌 값이 들어왔습니다."),
    INPUTVALUEPOSITIVE("입력에 음수가 들어왔습니다.")
    ;

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
