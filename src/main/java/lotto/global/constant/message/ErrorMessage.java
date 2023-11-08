package lotto.global.constant.message;

public enum ErrorMessage {
    MONEY_AMOUNT_ERROR("[ERROR] 0원은 입력할 수 없습니다."),
    MONEY_UNIT_ERROR("[ERROR] 1000원 단위로 입력이 가능합니다."),
    LOTTO_NUMBER_AMOUNT_ERROR("[ERROR] 6개의 번호를 입력해주세요"),
    LOTTO_NUMBER_DUPLICATION_ERROR("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_RANGE_ERROR("[ERROR] 1~45 사이의 숫자만 입력 가능합니다."),
    BONUS_NUMBER_DUPLICATION_ERROR("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다."),
    INT_FORMAT_ERROR("[ERROR] 입력값이 정수 형태가 아닙니다."),
    ;

    ErrorMessage(String text) {
        this.text = text;
    }

    private final String text;


    public String getText() {
        return text;
    }

}
