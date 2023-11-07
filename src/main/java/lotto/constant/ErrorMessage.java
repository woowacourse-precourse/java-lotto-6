package lotto.constant;

public enum ErrorMessage {

    INPUT_NOT_SIX("[ERROR]: 숫자 6개를 모두 입력해주세요."),
    INPUT_NUMBER_NUMBER_RANGE("[ERROR]:숫자는 1 ~ 45 사이여야 합니다."),
    INPUT_REDUNDANT("[ERROR]: 숫자가 중복됩니다."),
    INPUT_MOD_STANDARD_UNIT_NOT_ZERO("[ERROR]: 돈의 단위는 1000단위로 떨어져야 합니다.");



    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
