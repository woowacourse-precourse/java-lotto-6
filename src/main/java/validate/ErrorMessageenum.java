package validate;

public enum ErrorMessageenum {
    ERROR1("[ERROR] 숫자를 입력해주세요"),
    ERROR2("[ERROR] 가격을 천 단위로 입력해주세요"),
    ERROR3("[ERROR] 1부터 45사이의 숫자를 입력해 주세요."),
    ERROR4("[ERROR] 중복되지 않은 6개의 숫자를 입력해 주십시오."),
    ERROR5("[ERROR] 중복되지 않은 보너스 숫자를 입력해 주십시오.");



    private String message;

    ErrorMessageenum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
