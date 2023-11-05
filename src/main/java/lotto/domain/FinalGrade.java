package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public class FinalGrade {
    private final List<Rank> playerLottoResults;

    public FinalGrade(List<Rank> playerLottoResults) {
        this.playerLottoResults = playerLottoResults;
    }

    public BigDecimal getPlayerTotalPrize() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Rank rank : playerLottoResults) {
            totalPrice = totalPrice.add(rank.getPrice());
        }
        return totalPrice;
    }
}

