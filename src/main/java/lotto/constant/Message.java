package lotto.constant;

public enum Message {

    LOTTO_PURCHASE_MESSAGE("구매 금액을 입력해주세요."),
    WINNING_NUMBER_MESSAGE("당첨 번호를 입력해주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해주세요."),
    PURCHASE_AMOUNT_MESSAGE("개를 구매했습니다."),
    UNIT_MONEY_ERROR_MESSAGE("[ERROR] 구입 금액이 1000원 단위가 아닙니다."),
    MINIMUM_MONEY_ERROR_MESSAGE("[ERROR] 최소 구입 금액 미만입니다."),
    MAXIMUM_MONEY_ERROR_MESSAGE("[ERROR] 최대 구입 금액 초과입니다."),
    INPUT_MONEY_ERROR_MESSAGE("[ERROR] 구매 금액에 적합하지 않은 문자가 입력되었습니다."),
    INPUT_WINNING_NUMBERS_ERROR_MESSAGE("[ERROR] 당첨 번호에 적합하지 않은 문자가 입력되었습니다."),

    NUMBERS_SIZE_ERROR_MESSAGE("[ERROR] 번호의 갯수가 6개가 아닙니다."),
    WINNING_NUMBERS_SIZE_ERROR_MESSAGE("[ERROR] 당첨 번호의 갯수가 6개가 아닙니다."),
    WINNING_NUMBERS_OVER_RANGE_ERROR_MESSAGE("[ERROR] 1 ~ 45 범위를 벗어난 당첨 번호가 존재합니다."),
    BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE("[ERROR] 중복된 번호가 있습니다.");


    private String message;

    Message(String message){

        this.message = message;
    }

    public String getMessage(){

        return message;
    }
}