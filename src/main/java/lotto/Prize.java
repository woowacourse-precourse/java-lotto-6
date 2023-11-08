package lotto;
public class Prize {
    private final int countOfMatch;
    private final int amount;

    public Prize(int countOfMatch, int amount) {
        this.countOfMatch = countOfMatch;
        this.amount = amount;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getAmount() {
        return amount;
    }
}

