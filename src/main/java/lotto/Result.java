package lotto;

import lotto.enums.ResultType;

public class Result {
    int first;
    int second;
    int third;
    int forth;
    int fifth;

    int totalPrize;

    public Result() {
        this.first = 0;
        this.second = 0;
        this.third = 0;
        this.forth = 0;
        this.fifth = 0;
        this.totalPrize = 0;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getForth() {
        return forth;
    }

    public int getFifth() {
        return fifth;
    }

    public void updateResult(int matchCount, boolean bonusMatch){
        if(matchCount == 6) this.first++;
        if(matchCount == 5) checkIsSecond(bonusMatch);
        if(matchCount == 4) this.forth++;
        if(matchCount == 3) this.fifth++;
    }

    private void checkIsSecond(boolean bonusMatch) {
        if(bonusMatch){
            this.second++;
            return;
        }

        this.third++;
    }

}
