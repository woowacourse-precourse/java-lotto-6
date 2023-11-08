package lotto.model;

import java.util.LinkedHashMap;

public class WinningInfo {
    private LinkedHashMap<Long, Long> winnings;

    public WinningInfo() {
        winnings = new LinkedHashMap<>();
        for (Long i = 1L; i <= 7L; i++) {
            winnings.put(i, 0L);
        }
    }

    public LinkedHashMap<Long, Long> getWinnings() {
        return winnings;
    }

    public void setWinnings(LinkedHashMap<Long, Long> winnings) {
        this.winnings = winnings;
    }
}
