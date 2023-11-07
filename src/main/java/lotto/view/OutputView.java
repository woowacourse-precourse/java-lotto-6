package lotto.view;

public class OutputView {
    private static final String OUTPUT_LOTTO_AMOUNT = "\n%d개를 구매했습니다.";
    private static final String OUTPUT_LOTTO_RESULT = "\n당첨 통계\n---";
    private static final String OUTPUT_LOTTO_PROFIT = "총 수익률은 %,.1f%%입니다.";

    public static void printPlayerAmount(int amount) {
        System.out.println(formatPlayerAmount(amount));
    }

    public static void printPlayerLotto(String lotto) {
        System.out.println(lotto);
    }

    public static void printLottoResult() {
        System.out.println(OUTPUT_LOTTO_RESULT);
    }

    public static void printPrizeCount(String lottoCount) {
        System.out.println(lottoCount);
    }

    public static void printPrizeProfit(double rate) {
        System.out.println(formatPrizeProfit(rate));
    }

    private static String formatPlayerAmount(int amount) {
        return String.format(OUTPUT_LOTTO_AMOUNT, amount);
    }

    private static String formatPrizeProfit(double rate) {
        return String.format(OUTPUT_LOTTO_PROFIT, rate);
    }
}
