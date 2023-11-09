package lotto.message;

public enum ErrorMessage {
    PREFIX("[ERROR] "),
    BLANk("입력한 값이 존재하지 않습니다."),
    PURCHASE_AMOUNT_IS_NOT_NUMBER("구입금액은 숫자만 입력 가능합니다."),
    PURCHASE_AMOUNT_IS_NOT_ZERO("0원이 초과된 구입금액을 입력 부탁드립니다."),
    PURCHASE_AMOUNT_IS_NOT_ENOUGH("구입금액이 부족합니다, 최소 %s원 이상 입력 부탁드립니다."),
    PURCHASE_AMOUNT_IS_NOT_THOUSAND_UNITS("구입금액은 %s원 단위로 입력이 가능합니다."),
    LOTTO_IS_NOT_NUMBER("로또 번호는 숫자만 입력 가능합니다."),
    LOTTO_IS_NOT_SIZE("로또 번호의 갯수가 %s개가 아닙니다."),
    LOTTO_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자만 입력 가능 합니다."),
    LOTTO_DUPLICATE("로또 번호는 서로 다른 숫자만 입력 가능합니다."),
    BONUS_IS_NOT_NUMBER("보너스 번호는 숫자만 입력 가능합니다."),
    BONUS_OUT_OF_RANGE("보너스 번호는 1부터 45 사이의 숫자만 입력 가능합니다."),
    BONUS_DUPLICATE("당첨 번호에 없는 번호를 입력 부탁드립니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return this.message;
    }
}
