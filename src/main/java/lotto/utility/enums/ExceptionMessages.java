package lotto.utility.enums;

public enum ExceptionMessages {
    IS_EMPTY("[ERROR] 입력값이 없습니다."),
    NOT_NUMBER_MESSAGE("[ERROR] 구입 금액이 숫자가 아닙니다."),
    NOT_DIVISIBLE_BY_THOUSAND("[ERROR] 구입 금액이 1000원 단위가 아닙니다."),
    NOT_SIX_NUMBERS("[ERROR] 로또 번호의 개수가 6개가 아닙니다."),
    IS_NUMBERS_DUPLICATION("[ERROR] 로또 번호가 중복됩니다."),
    NOT_PROPER_COMMA_POSITION("[ERROR] 콤마의 위치가 올바르지 않습니다."),
    NOT_NUMBERS_AND_COMMA("[ERROR] 숫자와 콤마 이외의 문자가 입력되었습니다."),
    INCORRECT_NUMBER_COUNT("[ERROR] 당첨 번호의 개수가 올바르지 않습니다."),
    IS_DUPLICATE_NUMBERS("[ERROR] 당첨 번호의 중복 값이 있습니다."),
    OUT_OF_NUMBER_RANGE("[ERROR] 당첨 번호의 범위는 1부터 45입니다.");


    private String message;

    ExceptionMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
