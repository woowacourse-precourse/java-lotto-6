package lotto.domain;

import static lotto.common.util.LottoUtil.ZERO;

public class Rank {
    private int five = ZERO.getNumber();
    private int four = ZERO.getNumber();
    private int three = ZERO.getNumber();
    private int two = ZERO.getNumber();
    private int one = ZERO.getNumber();

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
