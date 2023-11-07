package lotto.utility.enums;

public enum ExceptionMessages {
    IS_EMPTY("[ERROR] 입력값이 없습니다. 구입 금액을 입력해주세요"),
    NOT_NUMBER_MESSAGE("[ERROR] 구입 금액이 숫자가 아닙니다."),
    NOT_DIVISIBLE_BY_THOUSAND("[ERROR] 구입 금액이 1000원 단위가 아닙니다."),
    NOT_SIX_NUMBERS("[ERROR] 로또 번호의 개수가 6개가 아닙니다."),
    IS_NUMBERS_DUPLICATION("[ERROR] 로또 번호가 중복됩니다.");


    private String message;

    ExceptionMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
