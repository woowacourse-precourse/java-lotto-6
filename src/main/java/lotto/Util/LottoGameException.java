package lotto.Util;

public enum LottoGameException {
    NOT_LOTTO_LENGTH("6개의 숫자가 아닙니다."),
    WRONG_BOUNDARY_NUMBER("1부터 45까지의 숫자만 입력 가능합니다."),
    DUPLICATE_WINNING_NUMBER("당첨 번호에 중복된 숫자가 포함되어 있습니다."),
    WRONG_WINNING_NUMBER("당첨 번호는 ','를 구분자로 6개의 숫자를 입력해주세요."),
    DUPLICATE_BONUS_NUMBER("당첨 번호에 포함된 보너스 번호입니다."),
    NOT_A_NUMBER("숫자만 입력 가능합니다."),
    NOT_DIVIDED_BY_LOTTO_UNIT("1,000 단위의 금액만 입력 가능합니다."),
    ;

    private String message;

    LottoGameException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
