package lotto;

public enum Ranks {
    FIRST(2000000000, 0),
    SECOND(30000000, 0),
    THIRD(1500000, 0),
    FOURTH(50000, 0),
    FIFTH(5000, 0);

    final int awards;
    int amount;

    Ranks(int awards, int amount){
        this.awards = awards;
    }
}
