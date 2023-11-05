package view;

public class OutputView {

    public static void printMoneyResult(int money) {
        System.out.println("\n" + money + "개를 구매했습니다.");
        //랜덤함수 콜
    }

    public static void printLottoResult() {
        System.out.println("\n당첨 통계\n---\n");
        //숫자 몇개가 일치하는지 콜
    }

    public static void printThreeCorrect(int three) {
        System.out.println("3개 일치 (5,000원) - " + three);
    }

    public static void printFourCorrect(int four) {
        System.out.println("4개 일치 (50,000원) - " + four);
    }

    public static void printFiveCorrect(int five) {
        System.out.println("5개 일치 (1,500,000원) - " + five);
    }

    public static void printFiveBonusCorrect(int five_bonus) {
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + five_bonus);
    }

    public static void printSixCorrect(int six) {
        System.out.println("6개 일치 (2,000,000,000원) - " + six);
    }

    public static void printRevenue(int[] lotto, int money) {
        float revenue = (lotto[3]*5000 + lotto[4]*50000 + lotto[5]*1500000 + lotto[6]*30000000 + lotto[7]*2000000000)/money;

        System.out.printf("총 수익률은 %.1f", revenue);
    }
}
