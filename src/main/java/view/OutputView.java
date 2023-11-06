package view;

import domain.Rank;

import java.util.List;

public class OutputView {

    public static void printMoneyResult(int money) {
        System.out.println("\n" + money/1000 + "개를 구매했습니다.");
        //랜덤함수 콜
    }

    public static void printRandomLotto(List<Integer> random_numbers) {
        System.out.println(random_numbers);
    }

    public static void printLottoResult() {
        System.out.println("\n당첨 통계\n---");
        //숫자 몇개가 일치하는지 콜
    }

    public static void printThreeCorrect(int three) {
        Rank rank = Rank.FIFTH;
        System.out.println(rank.getMatch() + three + "개");
    }

    public static void printFourCorrect(int four) {
        Rank rank = Rank.FOURTH;
        System.out.println(rank.getMatch() + four+ "개");
    }

    public static void printFiveCorrect(int five) {
        Rank rank = Rank.THIRD;
        System.out.println(rank.getMatch() + five+ "개");
    }

    public static void printFiveBonusCorrect(int five_bonus) {
        Rank rank = Rank.SECOND;
        System.out.println(rank.getMatch() + five_bonus+ "개");
    }

    public static void printSixCorrect(int six) {
        Rank rank = Rank.FIRST;
        System.out.println(rank.getMatch() + six+ "개");
    }

    public static void printRevenue(int[] lotto, int money) {
        printThreeCorrect(lotto[3]);
        printFourCorrect(lotto[4]);
        printFiveCorrect(lotto[5]);
        printFiveBonusCorrect(lotto[7]);
        printSixCorrect(lotto[6]);

        float revenue = (float)(lotto[3]*5000 + lotto[4]*50000 + lotto[5]*1500000 + lotto[6]*30000000 + lotto[7]*2000000000)/money;
        System.out.printf("총 수익률은 %.1f%%입니다.", revenue * 100);
    }

    public static void printException(String message) {
        System.out.println(message);
    }
}
