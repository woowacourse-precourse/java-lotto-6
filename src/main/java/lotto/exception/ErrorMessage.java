package lotto.exception;

public enum ErrorMessage {
    INCORRECT_AMOUNT("[ERROR] 잘못된 로또 금액입니다."),
    NOT_MATCH_COUNT("[ERROR] 당첨번호는 6개입니다."),
    DUPLICATE_NUMBER("[ERROR] 중복된 당첨번호 입니다."),
    DUPLICATE_WINNING_AND_BONUS_NUMBER("[ERROR] 당첨번호와 보너스 번호가 중복됩니다."),
    NOT_RANGE_NUMBER("[ERROR] 당첨번호는 1~45사이의 숫자입니다."),
    INCORRECT_BONUS_NUMBER("[ERROR] 보너스번호가 잘못 입력되었습니다."),
    NOT_FORMAT_NUMBER("[ERROR]");

    private final String message;
    ErrorMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
