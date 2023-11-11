package lotto.view;

public class OutputView {
    private static final String INFO_OF_NUM_OF_LOTTOS = "개를 구매했습니다.";
    private static final String RESULT_OF_LOTTOS = "당첨 통계\n---";
    private static final String RESULT_OF_TOTAL_PROFIT_IS = "총 수익률은 ";
    private static final String END = "%입니다.";

    public static void printPurchasedLottos(int numberOfLottos, String resultOfPurchasedLottos) {
        System.out.println(String.valueOf(numberOfLottos) + INFO_OF_NUM_OF_LOTTOS);
        System.out.println(resultOfPurchasedLottos);
    }

    public static void printResult(String resultsOfRanks, double totalProfit) {
        System.out.println(RESULT_OF_LOTTOS);
        System.out.println(resultsOfRanks);
        System.out.println(RESULT_OF_TOTAL_PROFIT_IS + String.format("%.1f", totalProfit) + END);
    }
}
