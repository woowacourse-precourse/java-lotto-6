package lotto.view;

public class OutputView {

    public static void askAmount() {
        print("구입금액을 입력해 주세요.");
    }

    public static void showTickets(int count) {
        print(count + "개를 구매했습니다.");
    }

    public static void askWinningNum() {
        print("당첨 번호를 입력해주세요.");
    }

    public static void askBonusNum() {
        print("보너스 번호를 입력해주세요.");
    }

    public static void showResults() {
        print("당첨 통계\n---");
    }

    public static void showYield(double yield) {
        print("총 수익률은 %.1f%%입니다.", yield);
    }

    private static void print(String str) {
        System.out.println(str);
    }

    private static void print(String str, double yield) {
        System.out.printf(str, yield);
    }

    private static void print(int count, String str) {
        System.out.println(count + str);
    }
}
