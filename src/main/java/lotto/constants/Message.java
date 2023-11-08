package lotto.constants;

public enum Message {
    ERROR("[ERROR] "),
    INPUT_COST("구입금액을 입력해 주세요."),
    PURCHASE_COMMENT("\n%d개를 구매했습니다.\n"),
    INPUT_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBERS("\n보너스 번호를 입력해 주세요."),
    PROFIT("총 수익률은 %.1f%%입니다.\n"),
    RESULT("\n당첨 통계\n---"),
    LOTTO_COUNT_ERROR("로또 번호는 6개의 숫자여야 합니다."),
    COST_INTEGER_ERROR("구입 금액은 숫자로 입력해야 합니다."),
    COST_MINIMUM_ERROR("구입 금액은 최소 1000원 이어야 합니다."),
    COST_UNIT_ERROR("구입 금액은 천원 단위로 입력해야 합니다."),
    LOTTO_NUMBER_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_DUPLICATED_ERROR("중복된 당첨 번호는 입력이 불가능합니다."),
    BONUS_NUMBER_ERROR("보너스 번호는 1과 45 사이의 숫자여야합니다."),
    BONUS_DUPLICATED_ERROR("당첨 번호와 중복된 숫자는 입력이 불가능합니다.");
    private final String message;

    Message(String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }

    public final String getErrorMessage() {
        return ERROR.getMessage() + message;
    }
}
