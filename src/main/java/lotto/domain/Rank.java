package lotto.domain;

public class Rank {
    private int five = 0;
    private int four = 0;
    private int three = 0;
    private int two = 0;
    private int one = 0;

    public void five() {
        five++;
    }

    public void four() {
        four++;
    }

    public void three() {
        three++;
    }

    public void two() {
        two++;
    }

    public void one() {
        one++;
    }

    public int getFive() {
        return five;
    }

    public int getFour() {
        return four;
    }

    public int getThree() {
        return three;
    }

    public int getTwo() {
        return two;
    }

    public int getOne() {
        return one;
    }
}
