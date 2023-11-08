package lotto.view;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_PURCHASE_AMOUNT = "개를 구매했습니다.";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_RACKET = "]";

    public static void printPurchaseCount(int ticketCount) {
        System.out.println(ticketCount + OUTPUT_PURCHASE_AMOUNT);
    }

    public static String printRandomLottoNumbers(List<Integer> randomLottoNumbers) {
        //[8, 21, 23, 41, 42, 43]
        StringBuilder randomLottoNumbersResult = new StringBuilder();
        randomLottoNumbersResult.append(OPEN_BRACKET);
        for (int i : randomLottoNumbers) {
            randomLottoNumbersResult.append(i);
            randomLottoNumbersResult.append(", ");
        }
        randomLottoNumbersResult.delete(randomLottoNumbersResult.length() - 2, randomLottoNumbersResult.length());
        randomLottoNumbersResult.append(CLOSE_RACKET);
        System.out.println(randomLottoNumbersResult);
        return String.valueOf(randomLottoNumbersResult);
    }

    public static void printResultByRanking(int[] rankings) {
        printResultMessage();
        System.out.println("3개 일치 (5,000원) - " + rankings[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + rankings[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankings[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankings[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankings[1] + "개");
    }

    private static void printResultMessage() {
        System.out.println("당첨 통계");
        System.out.println("--");
    }

    public static void printReturns(double returns) {
        System.out.print("총 수익률은 ");
        System.out.print(Math.round(returns) / 10.0);
        System.out.println("%입니다.");
    }
}
