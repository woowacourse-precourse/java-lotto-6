package Config;

public enum ErrorMessage {
    NON_NUMERIC("숫자를 입력하여야 합니다."),
    NON_MULTIPLE("%d 원 단위로 입력하여야 합니다."),
    NON_ZERO("0이 아닌 숫자를 입력하여야 합니다."),
    NOT_IN_RANGE("로또 번호는 %d부터 %d 사이의 숫자여야 합니다."),
    INVALID_NUMBER("\"%s\"로 구분되는 %d 개의 숫자를 입력하여야 합니다."),
    DUPLICATED_NUMBER("중복되지 않는 숫자를 입력하여야 합니다."),
    DUPLICATED_BONUS("당첨 번호와 중복되지 않는 숫자를 입력하여야 합니다.");

    private final String errorMessage;
    private final static String errorPrefix = "[ERROR] ";

    ErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorPrefix.concat(errorMessage);
    }
}
