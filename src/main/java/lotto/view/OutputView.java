package lotto.view;

import java.util.List;

public class OutputView {

    public static void responseLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void responseLottoRandomNumber(List<Integer> lottoNumberList) {
        System.out.print("[");
        for (int i = 0; i < lottoNumberList.size()-1; i++) {
            System.out.print(lottoNumberList.get(i) + ", ");
        }
        System.out.println(lottoNumberList.get(lottoNumberList.size()-1) + "]");
    }

    public static void responseWinningResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void responseWinningResultDetails(String message, int numberOfMatch) {
        System.out.println(message + numberOfMatch + "개");
    }

    public static void responseRateOfReturn(double earningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", earningRate) + "%입니다.");
    }
}
