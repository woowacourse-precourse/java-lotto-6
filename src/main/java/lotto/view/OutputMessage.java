package lotto.view;

import lotto.domain.Player;

public enum OutputMessage {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ENTER_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    SHOW_LOTTO_GAME_COUNT("%d개를 구매했습니다."),
    SHOW_LOTTO_STATISTIC_INTRODUCTION("당첨 통계"),
    SHOW_LOTTO_SEPARATOR_LINE("---"),
    SHOW_LOTTO_PRIZE("%d개 일치 (%d)원 - %개"),
    SHOW_LOTTO_PRIZE_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%d원) - %d개"),
    SHOW_LOTTO_RESULT_YIELD("총 수익률은 %s입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
