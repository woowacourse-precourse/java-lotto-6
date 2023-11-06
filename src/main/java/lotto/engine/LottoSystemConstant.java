package lotto.engine;

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

        @Override
        public String getMessage() {
            return message;
        }
    }

    public static final Policy<String> LOTTO_NUMBER_SEPARATOR = new Policy<>(",");

    public record Policy<T>(T value) {

    }
}
