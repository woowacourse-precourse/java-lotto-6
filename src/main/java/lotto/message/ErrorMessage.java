package lotto.message;

public enum ErrorMessage {
    NOT_DIGIT("[ERROR] 숫자가 아닌 값이 입력되었습니다."),
    INVALID_MONEY("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    NOT_IN_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    MORE_THAN_MAX_SIZE("[ERROR] 로또 번호의 개수가 6개를 초과했습니다."),
    EXIST_DUPLICATE("[ERROR] 로또 번호에 중복된 숫자가 존재합니다."),
    NOT_ONE_NUMBER("[ERROR] 보너스 번호는 1개의 숫자만 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
