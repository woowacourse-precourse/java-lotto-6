package lotto.domain;

public class Result {
    public static Winning win(int match, boolean bonus) {
        if (match == 6) return Winning.FIRST;
        else if (match == 5 && bonus) return Winning.SECOND;
        else if (match == 5) return Winning.THIRD;
        else if (match == 4) return Winning.FOURTH;
        else if (match == 3) return Winning.FIFTH;
        else return Winning.FAIL;
    }
}
