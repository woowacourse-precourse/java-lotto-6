package lotto.enums;

public enum Message {
    FIFTH("3개 일치 (5,000원) - "),
    FOURTH("4개 일치 (50,000원) - "),
    THIRD("5개 일치 (1,500,000원) - "),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST("6개 일치 (2,000,000,000원) - "),
    INPUT_PURCHASE_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_PURCHASE_AMOUNT("개를 구매했습니다."),
    OUTPUT_LOTTO_RESULT_STATS("\n당첨 통계\n---"),
    EXCEPTION_OUT_OF_BOUND("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    EXCEPTION_DUPLICATED_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    EXCEPTION_INPUT_MONEY_IS_NOT_NUMBER("[ERROR] 로또 구매 금액은 숫자여야 합니다."),
    EXCEPTION_INVALID_PURCHASE_MONEY("[ERROR] 로또 구매 금액은 1000원으로 나누어 떨어져야 합니다."),
    EXCEPTION_WINNING_NUMBERS_CONTAINS_BLANK("[ERROR] 당첨 번호에는 공백이 포함될 수 없습니다."),
    EXCEPTION_WINNING_NUMBERS_ENDS_WITH_COMMA("[ERROR] 당첨 번호는 콤마로 끝날 수 없습니다."),
    EXCEPTION_DUPLICATED_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    EXCEPTION_WINNING_NUMBERS_SIZE("[ERROR] 당첨 번호는 6자리여야 합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
