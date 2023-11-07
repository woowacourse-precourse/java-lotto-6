package lotto;

public class Messages {

    public enum lottoStartMessages{
        HOW_MUCH_BUY_MESSAGE("구입금액을 입력해 주세요."),
        HOW_MANY_BUY_MESSAGE("개를 구매했습니다."),
        MAKE_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
        MAKE_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
        WINNING_STATISTICS("당첨 통계"),
        BOARDER_LINE("---");
        private final String message;

        lottoStartMessages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

}
