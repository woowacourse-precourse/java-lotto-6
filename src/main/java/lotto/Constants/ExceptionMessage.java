package lotto.Constants;

public enum ExceptionMessage {
    ERROR_MESSAGE ("[ERROR] "),
    INPUT_EMPTY ("값을 입력 해주세요"),
    INPUT_TYPE ("자연수만 입력 가능합니다"),
    DIVISION_THOUSAND ("1000원 단위로 구매 가능합니다"),
    INPUT_DUPLICATE ("중복된 번호가 있습니다"),
    INTPUT_NUMBER_LENGTH ("1 ~ 45 사이의 번호만 입력 가능합니다"),
    SIX_NUMBER ("6개의 당첨 번호를 입력해 주세요"),
    ONE_NUMBER ("보너스 번호는 하나만 입력 가능합니다");

    private final String exceptionMassage;
    ExceptionMessage(String exceptionMessage){
        this.exceptionMassage = exceptionMessage;
    }

    public IllegalArgumentException throwexception(){
        return new IllegalArgumentException(ERROR_MESSAGE + exceptionMassage);
    }
}
