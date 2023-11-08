package lotto.constant;

public enum ErrorMessage {
    ERROR_MESSAGE("[ERROR]"),
    INPUTCONTAINNOTNUMBER(" 입력에 숫자가 아닌 값이 들어왔습니다."),
    INPUTVALUEPOSITIVE("입력에 음수가 들어왔습니다."),
    LOTTODUPLICATEDNUMBER("로또 번호가 중복됩니다"),
    LOTTONUMBERSIZEEXCEED("로또 번호 개수가 6을 초과합니다"),
    LOTTONUMBERRANGEOVER("범위를 넘어가는 값이 들어왔습니다"),
    NOTDIVISIONBYLOTTOPRICE("1000의 배수가 아닙니다"),
    MONEYISZERO("입력받은 금액이 0원입니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
