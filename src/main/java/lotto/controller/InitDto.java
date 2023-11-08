package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Winning;

public class InitDto {
    private Buyer buyer;
    private Winning winning;

    public InitDto(Buyer buyer, Winning winning) {
        this.buyer = buyer;
        this.winning = winning;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Winning getWinning() {
        return winning;
    }
}
