package support;

public enum Rate {
    FIRST(6,false,2000000000),
    SECOND(5,true,30000000),
    THIRD(5,false,1500000),
    FOURTH(4,false,50000),
    FIFTH(3,false,5000),
    MISS(0,false,0);


    private final int correct;
    private final boolean bonus;
    private final int prize;

    private Rate(int correct, boolean bonus, int prize) {
        this.correct = correct;
        this.bonus = bonus;
        this.prize = prize;
    }

    public static Rate valueOf(int correct , boolean bonus) {
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


}
