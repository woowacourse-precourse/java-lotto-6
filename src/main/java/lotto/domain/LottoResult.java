package lotto.domain;

public class LottoResult {
    private int three;
    private int four;
    private int five;
    private int fiveB;
    private int six;

    //increase
    public void increaseThree() {
        three++;
    }
    public void increaseFour() {
        four++;
    }
    public void increaseFive() {
        five++;
    }
    public void increaseFiveB() {
        fiveB++;
    }
    public void increaseSix() {
        six++;
    }

    //getter
    public int getThree() {
        return three;
    }

    public int getFour() {
        return four;
    }

    public int getFive() {
        return five;
    }

    public int getFiveB() {
        return fiveB;
    }

    public int getSix() {
        return six;
    }
}
