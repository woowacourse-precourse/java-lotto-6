package lotto.exception;

public enum ExceptionMessage {
    INVALID_NUMERIC("숫자만 입력이 가능합니다."),
    INVALID_NUMBER_COMMA("숫자와 콤마 구분자를 다시 확인해 주세요."),
    INVALID_PURCHASE_PRICE_UNIT("로또 구입 금액은 1,000원 단위로 입력이 가능합니다."),
    INVALID_SIZE_LOTTO_NUMBER("로또 번호의 개수는 6개만 가능합니다."),
    INVALID_RANGE_LOTTO_NUMBER("로또 번호는 1~45까지 숫자만 가능합니다."),
    DUPLICATION_LOTTO_NUMBER("중복된 로또 번호는 사용할 수 없습니다."),
    DUPLICATION_BONUS_NUMBER("로또 번호와 중복된 보너스 번호는 사용할 수 없습니다.")
    ;
    private final String prefix = "[ERROR] ";
    private String desc;

    ExceptionMessage(String description) {
        this.desc = description;
    }

    public String getDesc(){
        return prefix + this.desc;
    }

}
