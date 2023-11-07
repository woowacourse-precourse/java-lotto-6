package lotto;

public class LottoResult {
    private int three;
    private int four;
    private int five;
    private int five_bonus;
    private int six;

    public LottoResult() {
        this.three = 0;
        this.four = 0;
        this.five = 0;
        this.five_bonus = 0;
        this.six = 0;
    }

    public void plusCnt(int cnt, boolean correct) {
        if (cnt == 3) three++;
        if (cnt == 4) four++;
        if (cnt == 5) five++;
        if (cnt == 5 && correct) five_bonus++;
        if (cnt == 6) six++;
    }

    public int getThree() {
        return three;
    }

    public int getFour() {
        return four;
    }

    public int getFive() {
        return five;
    }

    public int getFive_bonus() {
        return five_bonus;
    }

    public int getSix() {
        return six;
    }

    public int total() {
        return 5000 * three + 50000 * four + 1500000 * five + 30000000 * five_bonus + 2000000000 * six;
    }
}
