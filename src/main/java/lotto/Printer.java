package lotto;

public class Printer {

    private static final String FIFTH_PLACE_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String FOURTH_PLACE_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String THIRD_PLACE_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String SECOND_PLACE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String FIRST_PLACE_MESSAGE = "6개 일치 (2,000,000,000원) - ";

    public static void printNumberOfLotto(int numberOfLotto) {
        System.out.println();
        System.out.println(numberOfLotto + "개를 구매했습니다.");
    }

    public static void printStatistics(WinningLottoCounter winningLottoCounter, double profitRate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println(FIFTH_PLACE_MESSAGE + winningLottoCounter.getCount(3) + "개");
        System.out.println(FOURTH_PLACE_MESSAGE + winningLottoCounter.getCount(4) + "개");
        System.out.println(THIRD_PLACE_MESSAGE + winningLottoCounter.getCount(5) + "개");
        System.out.println(SECOND_PLACE_MESSAGE + winningLottoCounter.getCount(0) + "개");
        System.out.println(FIRST_PLACE_MESSAGE + winningLottoCounter.getCount(6) + "개");
        System.out.print("총 수익률은 " + String.format("%,.1f", profitRate) + "%입니다.");

    }
}
