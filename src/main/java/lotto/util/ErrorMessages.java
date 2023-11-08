package lotto.util;

public enum ErrorMessages {

    ERROR_MESSAGE_PURCHASE_AMOUNT("[ERROR] 올바른 구매 금액을 입력해 주세요."),
    ERROR_MESSAGE_COMMA_NUMBERS("[ERROR] 올바른 형식(콤마 분리로 분리된 숫자형)으로 당첨 번호를 입력해 주세요"),
    ERROR_MESSAGE_BONUS_NUMBER("[Error] 올바른 형식(하나의 숫자로 이뤄진 숫자형)으로 보너스 번호를 입력해 주세요.");

    private final String message;

    ErrorMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
