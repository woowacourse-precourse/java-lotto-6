package lotto.view;

public class OutputView {

    public static void askAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void showTickets(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void askWinningNum() {
        System.out.println("당첨 번호를 입력해주세요.");
    }

    public static void askBonusNum() {
        System.out.println("보너스 번호를 입력해주세요.");
    }

    public static void showResults() {
        System.out.println("당첨 통계\n---");
    }

    public static void showYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.", yield);
    }
}
