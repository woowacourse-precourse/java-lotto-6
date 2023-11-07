package lotto.message;

/**
 * 출력시 메시지 정의 enum
 */
public enum OutputMessage {
    TOTAL_PRICE("구입금액을 입력해 주세요."),
    LOTTO_COUNT("개를 구매했습니다."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT_SUMMARY("당첨 통계\n---"),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
