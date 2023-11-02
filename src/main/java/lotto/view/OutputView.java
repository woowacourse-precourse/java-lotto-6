package lotto.view;

public class OutputView {
    public static class RequestMessage {
        public static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
        public static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
        public static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    }

    /**
     * 현재는 String을 파라미터로 가져오지만, Dto를 만들 예정.
     * Dto를 만들지 않고, 문자열로 가져오면 모델이 너무 많은 역할을 한다.
     */
    public static class ResponseMessage {
        public static String purchaseCount(int count) {
            return String.format("%s개를 구매했습니다.", count);
        }

        public static String winningNumbers(String numbers) {
            return String.format("[%s]", numbers);
        }

        public static String winningStatistics(String statistics) {
            return String.format("""
                당첨 통계
                ---
                %s""", statistics);
        }

        public static String totalReturn(String returnRate) {
            return String.format("총 수익률은 %s%%입니다.", returnRate);
        }
    }
}
