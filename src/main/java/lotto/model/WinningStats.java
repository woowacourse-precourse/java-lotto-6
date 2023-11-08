package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WinningStats {

    private final HashMap<WinningRank, Integer> winningStats;

    private int prizeSum;

    public WinningStats(HashMap<WinningRank, Integer> winningStats) {
        this.winningStats = winningStats;
    }

    public List<String> winningMessages() {
        ArrayList<String> winningMessage = new ArrayList<>();
        for (WinningRank rank : WinningRank.values()) {
            if (rank == WinningRank.LOSE)
                continue;
            StringBuilder sb = new StringBuilder();
            sb.append(rank.count);
            sb.append("개 일치");
            if(rank.bonus)
                sb.append(", 보너스 볼 일치");
            sb.append(" (");
            sb.append(rank.prizeCommaSeperated);
            sb.append("원) - ");
            sb.append(winningStats.get(rank));
            sb.append("개");
            winningMessage.add(sb.toString());

            prizeSum += rank.count * rank.prize;
        }
        return winningMessage;
    }
    public int winningPrize() {
        return prizeSum;
    }
}
