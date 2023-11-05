package lotto.domain;

public class Result {
    private int three;
    private int four;
    private int five;
    private int fiveNBonus;
    private int six;
    private String earningRate;

    public void addThree(){
        this.three++;
    }
    public void addFour(){
        this.four++;
    }

    public void addFive(){
        this.five++;
    }
    public void addFivenBonus(){
        this.fiveNBonus++;
    }
    public void addSix(){
        this.six++;
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

    public int getFiveNBonus() {
        return fiveNBonus;
    }

    public int getSix() {
        return six;
    }

}
