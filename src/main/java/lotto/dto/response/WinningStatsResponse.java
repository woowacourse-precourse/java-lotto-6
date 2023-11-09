package lotto.dto.response;

public class WinningStatsResponse {

    private final int count;

    public WinningStatsResponse(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}