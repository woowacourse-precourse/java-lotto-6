package lotto.utils;

public enum GameMessage {
    ENTER_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASED_TICKET_COUNT_MESSAGE("%d개를 구매했습니다."),
    ENTER_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_MESSAGE("당첨 통계"),
    RANK_MATCH_5_MESSAGE("5개 일치, 보너스 볼 일치 (%,d원) - %d개%n"),
    RANK_NOT_MATCH_5_MESSAGE("%d개 일치 (%,d원) - %d개%n");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
