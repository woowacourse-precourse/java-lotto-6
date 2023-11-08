package lotto.view;

public class OutputView {

    private static final String lottoNumberString = "개를 구매했습니다.";
    public static void printLottoNumber(long lottoNumber) {
        System.out.println();
        System.out.println(lottoNumber + lottoNumberString);
    }

    public static void printStatisics() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

}
