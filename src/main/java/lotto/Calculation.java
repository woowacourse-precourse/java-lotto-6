package lotto;

public class Calculation {
    public static String calculate(int price) {
        //(총 당첨금 / 구매금액) * 100
        float rate = (float) totalAwards() / price * 100;
        return String.format("%.1f", rate);
    }

    public static int doubles(Ranks ranks) {
        return ranks.awards * ranks.amount;
    }

    public static int totalAwards() {
        int total = 0;
        for (Ranks rank : Ranks.values()) {
            total += doubles(rank);
        }
        return total;
    }
}
