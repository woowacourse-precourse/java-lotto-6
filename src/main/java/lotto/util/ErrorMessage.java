package lotto.util;

public enum ErrorMessage {
    LOTTO_ISSUE_DISCONTINUED("로또를 더 이상 발행할 수 없습니다."),
    INVALID_LOTTO_NUMBERS_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATE_NUMBERS("로또 번호에 중복되는 숫자가 있으면 안 됩니다."),
    LOTTO_NUMBERS_OUT_OF_RANGE("로또 번호는 1에서 45사이의 숫자만 가능합니다."),
    BONUS_NUMBER_OUT_OF_RANGE("보너스 번호는 1에서 45 사이에 있어야 합니다."),
    DUPLICATE_WINNING_NUMBERS_AND_BONUS_NUMBER("당첨번호와 보너스 번호를 다르게 입력해주세요."),
    EMPTY_LOTTOS("Lottos는 최소 하나 이상의 Lotto로 이루어져야 합니다."),

    INVALID_PURCHASE_MONEY("구입 금액은 1000원 단위로 입력해주세요."),
    INVALID_PURCHASE_MONEY_AT_LEAST("구입 금액은 최소 1000원 이상으로 입력해야 합니다."),
    EXCEEDS_MAX_AMOUNT("금액은 100,000원 이하로 입력해야 합니다."),
    NEGATIVE_AMOUNT("구입 금액은 음수가 될 수 없습니다."),

    NOT_SET_ALL_FIELDS_NUMBERS("당첨번호 또는 보너스 번호가 설정되지 않았습니다."),
    INVALID_INPUT_FORMAT("쉼표 구분하여 숫자만 입력해주세요."),
    EMPTY_INPUT("입력 값이 비어있습니다."),
    INVALID_BONUS_NUMBER_COUNT("보너스 번호는 하나만 입력해주세요.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return ERROR_PREFIX + message;
    }
}
