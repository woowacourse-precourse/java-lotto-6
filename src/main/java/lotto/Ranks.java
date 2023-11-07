package lotto;

public enum Ranks {
    FIRST(2000000000, 0),
    SECOND(30000000, 0),
    THIRD(1500000, 0),
    FOURTH(50000, 0),
    FIFTH(5000, 0);

    final int awards;
    int amount;

    Ranks(int awards, int amount) {
        this.awards = awards;
    }

    public static void printResult(int price) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + Ranks.FIFTH.amount + "개");
        System.out.println("4개 일치 (50,000원) - " + Ranks.FOURTH.amount + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Ranks.THIRD.amount + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Ranks.SECOND.amount + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Ranks.FIRST.amount + "개");
        System.out.println("총 수익률은 " + Calculation.calculate(price) + "%입니다.");
    }
}
