package lotto.domain;

public class LottoController {
    public LottoController() {
    }

    public enum LottoMessage {
        PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
        PURCHASE_COUNT_MESSAGE("개를 구매했습니다."),
        REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
        WINNING_STATS_HEADER("당첨 통계 ln ---");

        private String message;

        LottoMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public void playGame() {
        int purchaseAmount = 0;


    }

    public void lottoPrint(LottoMessage lottoMessage, int purchaseAmount) {
        if (purchaseAmount > 0)
            System.out.print(purchaseAmount);
        System.out.println(lottoMessage.getMessage());
    }

}
