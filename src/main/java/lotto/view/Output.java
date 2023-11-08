package lotto.view;

import java.text.DecimalFormat;

public class Output {

    public static void boughtLottoNumMessage(int num) {
        System.out.printf("\n%d개를 구매했습니다.\n", num);
    }

    public static void ResultMessage() {
        System.out.println("\n당첨 통계\n---");
    }

    public static void CalculateResultMessage(float profit) {
        DecimalFormat df = new DecimalFormat("###,###.#");
        System.out.printf("총 수익률은 " + df.format(profit) + "%%입니다.");
    }

    public static void matchMessage(String message, int matchNum) {
        System.out.println(message + matchNum + "개");
    }

}
