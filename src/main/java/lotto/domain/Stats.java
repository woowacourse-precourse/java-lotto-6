package lotto.domain;

public class Stats {
    private static final int PRIZE_SIZE = 6;

    public static final int[] prizeArray = new int[PRIZE_SIZE];
    public static long purchased;
    public static long earned = 0;

    public static void setPurchased(int amount) {
        Stats.purchased = amount * 1000;
    }

    public static void update(LottoPrize rank) {
        prizeArray[rank.ordinal()]++;
        earned += rank.getPrize();
    }

    public static String calculateRate() {
        return String.format("%.1f", ((double) earned / purchased) * 100);
    }

    public static void printStat() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + prizeArray[LottoPrize.FIFTH_PRIZE.ordinal()] + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeArray[LottoPrize.FOURTH_PRIZE.ordinal()] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeArray[LottoPrize.THIRD_PRIZE.ordinal()] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeArray[LottoPrize.SECOND_PRIZE.ordinal()] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeArray[LottoPrize.FIRST_PRIZE.ordinal()] + "개");
        System.out.println("총 수익률은 " + calculateRate() + "%입니다.");
    }
}
