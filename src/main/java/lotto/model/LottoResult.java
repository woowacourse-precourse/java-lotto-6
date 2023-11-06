package lotto.model;

import java.util.List;

public class LottoResult {

    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;
    private int totalPrizeMoney;

    public LottoResult(int resetNumber) {
        this.first = resetNumber;
        this.second = resetNumber;
        this.third = resetNumber;
        this.fourth = resetNumber;
        this.fifth = resetNumber;
    }

    public void checkResult(List<Integer> winningMatchResult, List<Boolean> bonusMatchResult) {
        for (int i = 0; i < winningMatchResult.size(); i++) {
            if (winningMatchResult.get(i) == 6) {
                first++;
                totalPrizeMoney += LottoRankings.FIRST.getWinningAmount();
            }
            if (winningMatchResult.get(i) == 5 && bonusMatchResult.get(i)) {
                second++;
                totalPrizeMoney += LottoRankings.SECOND.getWinningAmount();
            }
            if (winningMatchResult.get(i) == 5 && !bonusMatchResult.get(i)) {
                third++;
                totalPrizeMoney += LottoRankings.THIRD.getWinningAmount();
            }
            if (winningMatchResult.get(i) == 4) {
                fourth++;
                totalPrizeMoney += LottoRankings.FOURTH.getWinningAmount();
            }
            if (winningMatchResult.get(i) == 3) {
                fifth++;
                totalPrizeMoney += LottoRankings.FIFTH.getWinningAmount();
            }
        }
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

    public int getFourth() {
        return fourth;
    }

    public int getFifth() {
        return fifth;
    }

    public int getTotalPrizeMoney() {
        return totalPrizeMoney;
    }
}
