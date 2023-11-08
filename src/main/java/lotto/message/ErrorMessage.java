package lotto.message;

public enum ErrorMessage {
    INVALID_LOTTO_PRICE_FORMAT("로또 구입 금액은 1,000원 단위로 입력해주시길 바랍니다."),
    LOTTO_PRICE_UNABLE_ZERO("로또 구입 금액은 1000원 이상이어야 합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복해서 입력할 수 없습니다."),
    INVALID_LOTTO_INPUT_FORMAT("당첨 번호 입력 형식을 확인해주시길 바랍니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1 ~ 45 사이의 수로 입력해주시길 바랍니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호 개수는 6개여야 합니다."),
    INVALID_DIVIDE_MONEY("");
    
    public final String message;
    private static final String prefix = "[ERROR]";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.join(" ", prefix, message);
    }
}
