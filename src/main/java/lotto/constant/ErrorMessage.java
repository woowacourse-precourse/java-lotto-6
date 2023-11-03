package lotto.constant;

public enum ErrorMessage {
    INPUT_STRING("[ERROR] 숫자가 아닌 문자열을 입력했습니다"),
    EMPTY("[ERROR] 입력을 안 했습니다"),
    NOT_CONTAIN_COMMA("[ERROR] ',' 을 빼고 숫자만 입력해주세요"),
    NOT_DIVIDE("[ERROR] 구입금액은 1000원 단위어야 합니다"),
    STRANGE_INTEGER("[ERROR] 구입금액은 0원 보다 커야합니다");


    private String message;

    ErrorMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
