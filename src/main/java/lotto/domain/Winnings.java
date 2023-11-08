package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Winnings {
    private List<Winning> winnings;
    private WinningCount winningCount;

    public Winnings() {
        winnings = new ArrayList<>();
        winningCount = new WinningCount();
    }

    public void add(Winning winning) {
        winnings.add(winning);
        winningCount.addWinningCount(winning);
    }

    public Winning getWinning(int index) {
        return winnings.get(index);
    }

    public WinningCount getWinningCount() {
        return winningCount;
    }
}
