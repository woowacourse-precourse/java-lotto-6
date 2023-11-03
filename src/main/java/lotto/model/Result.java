package lotto.model;

public class Result {
    private int match3;
    private int match4;
    private int match5;
    private int match5AndBonus;
    private int match6;

    public Result(){
        this.match3 = 0;
        this.match4 = 0;
        this.match5 = 0;
        this.match5AndBonus = 0;
        this.match6 = 0;
    }

    public void addMatch3() {
        this.match3++;
    }

    public void addMatch4() {
        this.match4++;
    }

    public void addMatch5() {
        this.match5++;
    }

    public void addMatch5AndBonus() {
        this.match5AndBonus++;
    }

    public void addMatch6() {
        this.match6++;
    }

    public int getMatch3() {
        return this.match3;
    }

    public int getMatch4() {
        return this.match4;
    }

    public int getMatch5() {
        return this.match5;
    }

    public int getMatch5AndBonus() {
        return this.match5AndBonus;
    }

    public int getMatch6() {
        return this.match6;
    }
}
