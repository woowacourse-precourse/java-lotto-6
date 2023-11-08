package lotto;

public class Same {
    private int threeSame;

    private int fourSame;

    private int fiveSame;

    private int fiveSameWithBonus;

    private int sixSame;

    public int getThreeSame() {
        return threeSame;
    }

    public int getFourSame() {
        return fourSame;
    }

    public int getFiveSame() {
        return fiveSame;
    }

    public int getFiveSameWithBonus() {
        return fiveSameWithBonus;
    }

    public int getSixSame() {
        return sixSame;
    }

    public void addThreeSame() {
        this.threeSame += 1;
    }

    public void addFourSame() {
        this.fourSame += 1;
    }

    public void addFiveSame() {
        this.fiveSame += 1;
    }

    public void addFiveWithBonus() {
        this.fiveSameWithBonus += 1;
    }

    public void addSixWithSame() {
        this.sixSame += 1;
    }
}