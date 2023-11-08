package lotto.domain;

public class LottoWinResult {

    private int threeWinCount;
    private int fourWinCount;
    private int fiveWinCount;
    private int fiveWithBonusCount;
    private int sixWinCount;

    public int getThreeWin(){
        return threeWinCount;
    }
    public int getFourWin(){
        return fourWinCount;
    }
    public int getFiveWin(){
        return fiveWinCount;
    }
    public int getFiveWithBonus(){
        return fiveWithBonusCount;
    }
    public int getSixWin(){
        return sixWinCount;
    }
    public void addThreeWinCount(){
        this.threeWinCount += 1;
    }
    public void addFourWinCount(){
        this.fourWinCount += 1;
    }
    public void addFiveWinCount(){
        this.fiveWinCount += 1;
    }
    public void addFiveWithBonusWinCount(){
        this.fiveWithBonusCount += 1;
    }
    public void addSixWinCount() {
        this.sixWinCount += 1;
    }

}
