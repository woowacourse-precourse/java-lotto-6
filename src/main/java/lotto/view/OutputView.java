package lotto.view;

public class OutputView {
    private static final String lottoAmountString = "개를 구매했습니다.";
    public static void printLottoAmount(long lottoAmount) {
        System.out.println();
        System.out.println(lottoAmount + lottoAmountString);
    }

    public void printWinningStatisics() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printYield() {
    }
}