package lotto.view;

public class OutputView {

    private static final String MONEY_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String BUY_MESSAGE = "\n%s개를 구매했습니다.";
    private static final String PRIZE_RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String REVENUE_MESSAGE = "총 수익률은 %,.1f%%입니다.";

    public void printBuyLottoMessage(int tickets) {
        String message = String.format(BUY_MESSAGE, tickets);
        System.out.println(message);
    }

    public void printLottos(String lottos) {

        System.out.println(lottos);
    }

    public void printPrizeResult(String prizeResult) {

        System.out.print(prizeResult);
    }

    public void printPrizeResultMessage() {
        System.out.println(PRIZE_RESULT_MESSAGE);

    }

    public void printRevenue(double revenue) {
        String message = String.format(REVENUE_MESSAGE, revenue);
        System.out.println(message);
    }

    public void printRequestMoneyMessage() {

        System.out.println(MONEY_REQUEST_MESSAGE);
    }

    public void printRequestWinningNumberMessage() {

        System.out.println(WINNING_NUMBERS_REQUEST_MESSAGE);
    }

    public void printRequestBonusNumber() {

        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE);
    }
}
