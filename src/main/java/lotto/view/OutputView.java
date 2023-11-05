package lotto.view;

public class OutputView {
    public static void printLottoNumbers(int number, String lottoNumbers) {
        System.out.println(number + "개를 구매했습니다.");
        System.out.println(lottoNumbers);
    }

    public static void printResult(String result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(result);
    }

    public static void printProfitPercentage(String result) {
        System.out.printf("총 수익률은 %s입니다.", result);
    }
}
