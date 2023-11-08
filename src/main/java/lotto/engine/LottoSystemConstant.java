package lotto.engine;

import java.util.Map;
import lotto.common.Message;

public record LottoSystemConstant() {

    public enum TextMessage implements Message {
        INPUT_MONEY_FOR_BUYING_LOTTO("구입금액을 입력해 주세요."),
        INPUT_WINNING_NUMBERS_LOTTO("당첨 번호를 입력해 주세요."),
        INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
        AGGREGATION_PREFIX("당첨 통계\n" + "---"),
        ERROR_PREFIX("[ERROR] ");
        private final String message;

        TextMessage(String message) {
            this.message = message;
        }

        public enum Pattern {
            BUY_RESULT("%s개를 구매했습니다."),
            AGGREGATION_RESULTS("""
                    3개 일치 (5,000원) - %d개
                    4개 일치 (50,000원) - %d개
                    5개 일치 (1,500,000원) - %d개
                    5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                    6개 일치 (2,000,000,000원) - %d개
                    총 수익률은 %.1f%%입니다.
                    """);
            private final String message;

            Pattern(String message) {
                this.message = message;
            }

            public String getMessage() {
                return message;
            }
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

    public static final Policy<Integer> LOTTO_NUMBER_MINIMUM_VALUE = new Policy<>(1);
    public static final Policy<Integer> LOTTO_NUMBER_MAXIMUM_VALUE = new Policy<>(45);
    public static final Policy<Integer> LOTTO_NUMBER_LENGTH = new Policy<>(6);
    public static final Policy<String> LOTTO_NUMBER_SEPARATOR = new Policy<>(",");
    public static final Policy<Integer> LOTTO_SPECIAL_MATCH_CONDITION_NUMBER = new Policy<>(5);
    public static final Policy<Integer> LOTTO_SPECIAL_MATCH_PRIZE = new Policy<>(5);
    public static final Policy<Integer> LOTTO_PRICE = new Policy<>(1000);
    public static final Policy<Integer> LOTTO_MONEY_MAXIMUM_VALUE = new Policy<>(100_000);
    public static final Policy<Integer> LOTTO_MINIMUM_NUMBER_OF_WINNINGS = new Policy<>(3);
    public static final Policy<Integer> LOTTO_MAXIMUM_NUMBER_OF_WINNINGS = new Policy<>(6);

    public static final Policy<Map<Integer, Integer>> WINNING_PRIZE = new Policy<>(
            Map.of(
                    3, 5000,
                    4, 50000,
                    5, 1_500_000,
                    6, 2_000_000_000
            )
    );


    public record Policy<T>(T value) {

    }
}
