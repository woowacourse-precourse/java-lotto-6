package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningResult {
    private List<Integer> winningCount = new ArrayList<>();
    private Long totalPrice = 0L;
    private Integer lottoCount = 0;

    public WinningResult() {
        final int WINNING_TYPE_COUNT = LottoSetting.WINNING_TYPE_COUNT.getValue();
        for (int count = 0; count < WINNING_TYPE_COUNT; count++) {
            winningCount.add(0);
        }
    }

    public WinningResult(int matchingCount, boolean bonusMatching) {
        this();
        lottoCount = 1;
        for (WinningType type : WinningType.values()) {
            if (isMatched(type, matchingCount, bonusMatching)) {
                int index = type.getIndex();
                winningCount.set(index, 1);
                totalPrice += type.getPrice();
                break;
            }
        }
    }

    private boolean isMatched(WinningType type, int matchingCount, boolean bonusMatching) {
        int requiredScore = getScore(type.getMatchingCount(), type.getBonusMatching());
        int score = getScore(matchingCount, bonusMatching);

        if (score >= requiredScore) {
            return true;
        }
        return false;
    }

    private int getScore(int matchingCount, boolean bonusMatching) {
        int score = matchingCount * 10;
        if (bonusMatching) {
            score++;
        }
        return score;
    }

    public void add(WinningResult winningResult) {
        for (WinningType type : WinningType.values()) {
            int index = type.getIndex();
            int currCount = this.winningCount.get(index);
            int added = winningResult.winningCount.get(index);
            this.winningCount.set(index, currCount + added);
            totalPrice += type.getPrice() * added;
        }
        this.lottoCount += winningResult.lottoCount;
    }

    public List<Integer> getWinningCount() {
        return winningCount;
    }

    public int getWinningCountOfType(WinningType type) {
        int index = type.getIndex();
        return winningCount.get(index);
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public int getLottoCount() {
        return lottoCount;
    }

}
