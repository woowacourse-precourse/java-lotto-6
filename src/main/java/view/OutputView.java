package view;

public class OutputView {

    static private int earningRate;
    static final private String lineSeparator = System.lineSeparator();
    static final String MONEY_INPUT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    static final String PURCHASING_RESULT_MESSAGE = "개를 구매했습니다.";
    static final String WINNING_NUMBER_INPUT_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    static final String WINNING_RESULT_TITLE = "당첨 통계" + lineSeparator + "---" + lineSeparator;
    static final String EARNING_RATE_RESULT_MESSAGE = "총 수익률은" + earningRate + "입니다.";

    void  printMoneyInputRequestMessage() {
        System.out.println(MONEY_INPUT_REQUEST_MESSAGE);
    }

    void printPurchasingResultMessage() {
        System.out.println(PURCHASING_RESULT_MESSAGE);
    }

    void printWinningNumberInputRequestMessage() {
        System.out.println(WINNING_NUMBER_INPUT_REQUEST_MESSAGE);
    }

    void printWinningResultTitle() {
        System.out.println(WINNING_RESULT_TITLE);
    }

    public static void printWinningResult(Map<Integer, Integer> winningResult) {
        System.out.println("3개 일치 (5,000원) - " + winningResult.get(3) +"개");
        System.out.println("4개 일치 (50,000원) - " + winningResult.get(4) +"개");
        System.out.println("5개 일치 (1,500,000원) - " + winningResult.get(5)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningResult.get(6) +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningResult.get(7) +"개");
    }
    public static void printEarningRateResultMessage(double earningRate) {
        System.out.println("총 수익률은 " + earningRate + "% 입니다.");
    }
}
