package lotto.domain.result;

import lotto.domain.prize.Prize;

public record Result(long count, boolean isBonus) {

    public Prize substitutePrize() {
        return Prize.findPrize(this);
    }
}