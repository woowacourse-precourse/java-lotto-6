package lotto.support;

public enum Rate {
    FIRST("first", 6, false, 2000000000), SECOND("second", 5, true, 30000000), THIRD("third", 5, false, 1500000), FOURTH("fourth", 4, false, 50000), FIFTH("fifth", 3, false, 5000), MISS("miss", 0, false, 0);


    private final String rank;
    private final int correct;
    private final boolean bonus;
    private final int prize;

    private Rate(String rank, int correct, boolean bonus, int prize) {
        this.rank = rank;
        this.correct = correct;
        this.bonus = bonus;
        this.prize = prize;
    }

    public static Rate valueOf(int correct, boolean bonus) {
        if (correct == 6) {
            return FIRST;
        }
        if (correct == 5 && bonus) {
            return SECOND;
        }
        if (correct == 5) {
            return THIRD;
        }
        if (correct == 4) {
            return FOURTH;
        }
        if (correct == 3) {
            return FIFTH;
        }
        return MISS;
    }

    public String getRank() {
        return this.rank;
    }

    public int getPrize() {
        return this.prize;
    }


}
