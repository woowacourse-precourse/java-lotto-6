package lotto.model;

public class Reward {
    private final int amount;

    private Reward(int amount) {
        this.amount = amount;
    }

    public static Reward win(MatchResult matchResult) {
        return new Reward(Reward.calculate(matchResult));
    }

    private static int calculate(MatchResult matchResult) {
        return matchResult.getMatchResult()
                .entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }

    public int getAmount() {
        return amount;
    }
}