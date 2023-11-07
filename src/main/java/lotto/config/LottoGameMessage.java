package lotto.config;

public enum LottoGameMessage {
    INPUT_GET_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_PURCHASED_LOTTO_SIZE("개를 구매했습니다."),
    OUTPUT_WINNING_RESULTS("당첨 통계"),
    OUTPUT_WINNING_RESULTS_LINES("---"),
    ;
    private final String message;

    LottoGameMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
