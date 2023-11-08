package lotto.domain;

import java.util.List;
import lotto.vo.response.WinningResponse;

public class WinningRanks {
    private final List<Rank> ranks;

    public WinningRanks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public WinningResponse convertToResponse() {
        return new WinningResponse(ranks);
    }

    public Profit determineProfit() {
        return new Profit(ranks);
    }
}
