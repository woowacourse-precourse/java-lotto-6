package lotto.domain;

public class Rate {

    public static int sum = 0;

    public static double calcRate(Ranking ranking, int tickets) {
        for (Rank rank : Rank.values()) {
            sumMoney(ranking.getCount(rank), rank.getReward());
        }
        return (double) sum / (tickets * 1000) * 100;
    }

    public static void sumMoney(int count, int reward) {
        sum += count * reward;
    }

}
