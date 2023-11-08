package lotto.View.Constants;

public enum ErrorMessage {


    CONSIST_ONLY_NUMBER ("[ERROR] 숫자만을 입력해야 합니다."),

    OVER_ONE_THOUSAND  ("[ERROR] 1000원 이상을 입력해야 합니다."),

    ZERO_MODULO ("[ERROR] 입력금액을 1000으로 나눈 나머지가 0 이어야 합니다."),

    CONSIST_NUMBER_AND_COMMA("[ERROR] 숫자와 콤마\",\"만을 입력해야 합니다."),

    FIVE_COMMA("[ERROR] 5개의 콤마를 가지고 있어야 합니다."),

    SIX_ELEMENT("[ERROR] 6개의 숫자로 구성 되어야 합니다."),

    OUT_OF_NUMBER_RANGE("[ERROR] 1 ~ 45 사이의 값을 입력 해야 합니다" ),

    SAME_NUMBER_EXIST("[ERROR] 서로 다른 숫자를 입력해야 합니다."),

    MUST_INPUT ("[ERROR] 값을 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {this.message = message;}

    public String getMessage(){
        return message;
    }
}
