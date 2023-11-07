package lotto.dto;

import java.util.HashMap;
import java.util.List;

public class LottoResultDto {
    private final HashMap<Integer, Integer> winningStatistics;
    private final List<Long> correctWinningsCount;
    private final List<Boolean> correctBonuses;

    public LottoResultDto(HashMap<Integer, Integer> winningStatistics,
                          List<Long> correctWinningsCount,
                          List<Boolean> correctBonuses) {
        this.winningStatistics = winningStatistics;
        this.correctWinningsCount = correctWinningsCount;
        this.correctBonuses = correctBonuses;
    }

    public HashMap<Integer, Integer> getWinningStatistics() {
        return winningStatistics;
    }

    public List<Long> getCorrectWinningsCount() {
        return correctWinningsCount;
    }

    public List<Boolean> getCorrectBonuses() {
        return correctBonuses;
    }
}
