package lotto.view;

import java.util.List;

public class OutputView {

    public static void printPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCount(int lottoCnt) {
        System.out.println("\n" + lottoCnt + "개를 구매했습니다.");
    }

    public static void printLotto(List<Integer> lotto) {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < lotto.size(); i++) {
            builder.append(lotto.get(i));
            if (i < lotto.size() - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        System.out.println(builder);
    }


    public static void printAnswer() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printBonus() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printPrice(String result, String price, int cnt) {
        System.out.println(result + "(" + price + "원) - " + cnt + "개");
    }

    public static void printResult() {
        System.out.println("\n당첨 통계\n---");
    }

    public static void printProfit(Float reward) {
        System.out.println("총 수익률은 " + String.format("%.1f%%", reward) + "입니다.");
    }

    public static void printException(String exceptionMessage) {
        System.out.print("[ERROR] ");
        System.out.println(exceptionMessage);
    }
}
