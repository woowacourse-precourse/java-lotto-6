package lotto;

public enum WinningStatus {

    three(3, "(5,000원)", 5000), four(4, "(50,000원)", 50000) ,
    five(5, "(1,500,000원)" , 1500000), bonus(5, "(30,000,000원)", 30000000),
    six(6, "(2,000,000,000원)", 2000000000);

    private int matchNumberInfo, intWinningMoney;
    private String winningMoney;

    WinningStatus(int matchNumberInfo, String winningMoney, int intWinningMoney){
        this.matchNumberInfo = matchNumberInfo;
        this.winningMoney = winningMoney;
        this.intWinningMoney = intWinningMoney;
    }
    public int getMatchNumberInfo() {
        return matchNumberInfo;
    }

    public String getWinningMoney(){
        return winningMoney;
    }

    public int getIntWinningMoney() {
        return intWinningMoney;
    }
}
