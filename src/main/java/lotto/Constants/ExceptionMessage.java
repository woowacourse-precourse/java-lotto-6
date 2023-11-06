package lotto.Constants;

public enum ExceptionMessage {
    INPUT_EMPTY ("공백은 입력 불가능 합니다."),
    INPUT_TYPE ("올바른 숫자를 입력해 주세요."),
    INPUT_ZERO ("0보다 큰 숫자를 입력해 주세요."),
    DIVISION_THOUSAND ("1000원 단위로 구매 가능합니다."),
    INPUT_DUPLICATE ("중복된 번호가 있습니다."),
    INTPUT_NUMBER_LENGTH ("1 ~ 45 사이의 번호만 입력 가능합니다."),
    SIX_NUMBER ("6개의 당첨 번호를 입력해 주세요."),
    NUMBER_OVERFLOW ("int의 범위를 벗어났습니다."),
    IN_WINNING_NUMBERS ("당첨 번호에 포함되지 않는 번호를 입력해 주세요.");

    private final static String ERROR_MESSAGE = "[ERROR] ";
    private final String exceptionMassage;
    ExceptionMessage(String exceptionMessage){
        this.exceptionMassage = ERROR_MESSAGE + exceptionMessage;
    }

    public IllegalArgumentException throwexception(){
        return new IllegalArgumentException(exceptionMassage);
    }
}
