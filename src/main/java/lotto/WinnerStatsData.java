package lotto;

public class WinnerStatsData {

    int match3Numbers = 0;
    int match4Numbers = 0;
    int match5Numbers = 0;
    int match5NumbersWithBonus = 0;
    int match6Numbers = 0;

    public int getMatch3Numbers() {
        return match3Numbers;
    }

    public void increaseMatch3Numbers() {
        this.match3Numbers++;
    }

    public int getMatch4Numbers() {
        return match4Numbers;
    }

    public void increaseMatch4Numbers() {
        this.match4Numbers++;
    }

    public int getMatch5Numbers() {
        return match5Numbers;
    }

    public void increaseMatch5Numbers() {
        this.match5Numbers++;
    }

    public int getMatch5NumbersWithBonus() {
        return match5NumbersWithBonus;
    }

    public void increaseMatch5NumbersWithBonus() {
        this.match5NumbersWithBonus++;
    }

    public int getMatch6Numbers() {
        return match6Numbers;
    }

    public void increaseMatch6Numbers() {
        this.match6Numbers++;
    }
}
