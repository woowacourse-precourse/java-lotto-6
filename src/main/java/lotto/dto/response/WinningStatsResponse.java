package lotto.dto.response;

import lotto.domain.result.LottoPrize;

public class WinningStatsResponse {

    private final int count;
    public WinningStatsResponse(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }
}