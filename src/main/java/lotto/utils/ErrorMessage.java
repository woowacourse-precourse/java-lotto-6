package lotto.utils;

public enum ErrorMessage {

    PREFIX("[ERROR] "),
    INVALID_INPUT_SIZE("당첨 번호 6개를 입력해주세요."),
    INVALID_INPUT_NUMBER("당첨 번호는 1~45 사이의 수를 입력해주세요."),
    DUPLICATE_INPUT_NUMBER("중복되지 않는 숫자를 입력하세요."),
    INVALID_INPUT_TYPE("구입 금액은 숫자만 입력 가능합니다."),
    INVALID_INPUT_PRICE("구입 금액을 확인해주세요. 1장당 1000원");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getExceptionMessage(){
        return PREFIX.message + this.message;
    }


}
