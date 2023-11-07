package lotto.console.game.lotto.core;

public class Match {
    int count;
    boolean bonus;

    public Match() {
        count = 0;
        bonus = false;
    }

    public void addCount(){
        count++;
    }

    public void isBonus(){
        bonus = true;
    }

    public Rank getRank() {
        if (count == 6) return Rank.FIRST;
        if (count == 5 && bonus) return Rank.SECOND;
        if (count == 5) return Rank.THIRD;
        if (count == 4) return Rank.FOURTH;
        if (count == 3) return Rank.FIFTH;
        return Rank.NONE;
    }
}
