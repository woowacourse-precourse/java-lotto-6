package lotto.model;

import static lotto.model.constant.LottoPrizeConstant.FIFTH;
import static lotto.model.constant.LottoPrizeConstant.FIRST;
import static lotto.model.constant.LottoPrizeConstant.FOURTH;
import static lotto.model.constant.LottoPrizeConstant.SECOND;
import static lotto.model.constant.LottoPrizeConstant.THIRD;

public record LottoResult(int first, int second, int third, int fourth, int fifth) {

    public long totalPrize() {
        return (first * FIRST.getMoney()) +
                (second * SECOND.getMoney()) +
                (third * THIRD.getMoney()) +
                (fourth * FOURTH.getMoney()) +
                (fifth * FIFTH.getMoney());
    }
}
