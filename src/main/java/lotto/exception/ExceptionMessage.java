package lotto.exception;

public enum ExceptionMessage {
    //Nullsafety
    BLANK_IMPUT("입력은 공백이 될 수 없다."),
    //LottoNumber
    OUT_OF_LOTTO_NUMBER_LENGTH("로또 번호의 숫자 범위는 1~45까지이다."),

    //Lotto
    DUPLICATE_LOTTO_NUMBER("로또 번호의 숫자가 중복됩니다."),
    INVAILD_LOTTO_SIZE("로또 번호는 6개 숫자로 이루어졌다"),

    //Lottos
    EMPTY_LOTTOS("로또들이 발행되지 않았다"),

    //Money
    ILLEGAL_NUMBER("입력은 0 이상의 정수이어야 한다."),
    NOT_DEVIDED_MONEY("로또 구입 금액은 1000원 단위로 입력을 받아야한다.");


    private final static String EXCEPTION_HEADER = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return EXCEPTION_HEADER + message;
    }
}
