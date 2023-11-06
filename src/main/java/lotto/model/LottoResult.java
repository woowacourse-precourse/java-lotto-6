package lotto.model;

import java.util.List;

public class LottoResult {

    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

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
            }
            if (winningMatchResult.get(i) == 5 && bonusMatchResult.get(i)) {
                second++;
            }
            if (winningMatchResult.get(i) == 5 && !bonusMatchResult.get(i)) {
                third++;
            }
            if (winningMatchResult.get(i) == 4) {
                fourth++;
            }
            if (winningMatchResult.get(i) == 3) {
                fifth++;
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
}
