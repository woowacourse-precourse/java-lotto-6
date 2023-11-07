package lotto.view;

public enum ErrorMessage {
    INCORRECT_INPUT_TYPE_ERROR_MESSAGE("[ERROR] 로또 번호는 숫자여야 합니다."),
    OUT_OF_RANGE_ERROR_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    IS_NOT_A_UNIT_ERROR_MESSAGE("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다."),
    WINNING_LOTTO_NUMBER_SIZE_ERROR_MESSAGE("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
    private String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
