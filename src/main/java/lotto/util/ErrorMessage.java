package lotto.util;

public enum ErrorMessage {

    BONUS_NUMBER_IS_DUPLICATED_MESSAGE("[중복된 번호입니다."),
    LOTTO_SIZE_IS_OVER("로또번호의 값이 6자리가 아닙니다."),
    LOTTO_NUMBER_IS_DUPLICATED("중복된 로또번호가 있습니다."),
    NUMBER_IS_OVER_RANGE("로또번호는 1부터 45까지의 값을 가져야 합니다."),
    PRICE_NOT_INTEGER_ERROR_MESSAGE("입력값이 숫자가 아닙니다."),
    INPUT_HAS_NOT_COMMA_MESSAGE("당첨 번호를 ,(쉼표)로 구분해주세요."),
    INPUT_NUMBERS_SIZE_IS_NOT_CORRECT_MESSAGE("입력받은 숫자가 6자리가 아닙니다."),
    PRICE_IS_LOWER_ERROR("로또의 가격이 1000원보다 낮습니다."),
    PRICE_IS_NOT_FORMATTED_MESSAGE("로또의 가격이 맞지 않습니다.");

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}