package lotto.constant;

import java.util.List;

public enum Ranking {
    FIFTH(3, 5000, 0, "3개 일치 (5,000원) - %s개"),
    FORTH(4, 50000, 1,"4개 일치 (50,000원) - %s개"),
    THIRD(5, 1500000, 2, "5개 일치 (1,500,000원) - %s개"),
    SECOND(5, 30000000, 3, "5개 일치, 보너스 볼 일치 (30,000,000원) - %s개"),
    FIRST(6, 2000000000, 4, "6개 일치 (2,000,000,000원) - %s개");

    private int winNum;
    private int prize;
    private int index;
    private final String winningMessage;
    Ranking(int winNum, int prize, int index, String winningMessage){
        this.winNum = winNum;
        this.prize = prize;
        this.index = index;
        this.winningMessage = winningMessage;
    }

    public int getWinNum(){
        return winNum;
    }

    public int getPrize(){
        return prize;
    }

    public int getIndex() {
        return index;
    }

    public String formatMessage(int parameter){
        return String.format(winningMessage,parameter);
    }

}
