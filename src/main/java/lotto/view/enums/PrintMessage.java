package lotto.view.enums;

public enum PrintMessage {
    INPUT_PURCHASE_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    TICKET_NUMBER_FOOTER("개를 구매했습니다."),
    LOTTO_NUMBER_HEADER("["),
    LOTTO_NUMBER_FOOTER("]\n"),
    JOIN_DELIMITER(", "),
    WINNING_HEADER("당첨 통계\n"),
    THREE_HYPHEN("---\n"),
    RANK_FOOTER("개\n"),
    RATE_OF_RETURN_HEADER("총 수익률은 "),
    RATE_OF_RETURN_FOOTER("%입니다.");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
