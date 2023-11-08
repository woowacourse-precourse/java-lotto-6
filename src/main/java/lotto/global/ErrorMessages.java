package lotto.global;

public enum ErrorMessages {

    PREFIX("[ERROR] "),
    LOTTO_NUMBER_SIZE_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 1~45 사이여야 합니다."),
    LOTTO_PRICE_ERROR("구입 금액은 1000원 이상이어야 합니다."),
    LOTTO_PRICE_UNIT_ERROR("구입 금액은 1000원 단위로 입력 가능합니다."),
    NUMBER_FORMAT_ERROR("0이상의 숫자만 입력 가능합니다.");

    private final String value;

    ErrorMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return PREFIX.value + value;
    }
}