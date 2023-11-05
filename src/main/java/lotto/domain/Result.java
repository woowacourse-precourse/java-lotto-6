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
        return this.three;
    }

    public int getFour() {
        return this.four;
    }

    public int getFive() {
        return this.five;
    }

    public int getFiveNBonus() {
        return this.fiveNBonus;
    }

    public int getSix() {
        return this.six;
    }
    public String getEarningRate(){
        return this.earningRate;
    }

    public void setEarningRate(String earningRate){
        this.earningRate = earningRate;
    }

}
