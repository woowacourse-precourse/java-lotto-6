package lotto.View;

import java.util.ArrayList;
import java.util.List;

public enum SystemMessage {
    GUESS_BUY_LOTTO("구입금액을 입력해 주세요."),
    RESULT_BUY_LOTTO("%d개를 구매했습니다."),

    GUESS_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    GUESS_BONUS_NUMBERS("보너스 번호를 입력해 주세요."),

    RESULT_MATCHING_NUMBERS("당첨 통계\n" + "---"),
    THREE_MATCH("3개 일치 (5,000원) - %d개\n"),
    FOUR_MATCH("4개 일치 (50,000원) - %d개\n"),
    FIVE_MATCH("5개 일치 (1,500,000원) - %d개\n"),
    BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    SIX_MATCH("6개 일치 (2,000,000,000원) - %d개\n"),

    RESULT_RATE_RETURN("총 수익률은 %.1f%%입니다.\n"),

    ERROR_INVALID_LOTTO_AMOUNT("[ERROR] 1,000원 단위로 입력해 주세요."),
    ERROR_INVALID_INPUT("[ERROR] 숫자만 입력해 주세요."),

    ERROR_INVALID_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_INVALID_COUNT("[ERROR] 로또 번호는 총 6개의 중복되지않는 숫자여야 합니다."),
    ERROR_DUPLICATE_BONUS("[ERROR] 당첨 번호와 중복되지않는 숫자여야 합니다."),
    ERROR_INVALID_BONUS("[ERROR] 보너스 번호는 1부터 45 사이의 숫자 1개여야 합니다.");

    private final static int THREE_MATCH_REWARD = 5000;
    private final static int FOUR_MATCH_REWARD = 50000;
    private final static int FIVE_MATCH_REWARD = 1500000;
    private final static int BONUS_MATCH_REWARD = 30000000;
    private final static int SIX_MATCH_REWARD = 2000000000;

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static List<String> getResultMessages() {
        List<String> messages = new ArrayList<>();
        messages.add(THREE_MATCH.getMessage());
        messages.add(FOUR_MATCH.getMessage());
        messages.add(FIVE_MATCH.getMessage());
        messages.add(BONUS_MATCH.getMessage());
        messages.add(SIX_MATCH.getMessage());
        return messages;
    }

    public static List<Integer> getReward() {
        List<Integer> reward = new ArrayList<>();
        reward.add(THREE_MATCH_REWARD);
        reward.add(FOUR_MATCH_REWARD);
        reward.add(FIVE_MATCH_REWARD);
        reward.add(BONUS_MATCH_REWARD);
        reward.add(SIX_MATCH_REWARD);
        return reward;
    }
}
