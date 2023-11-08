package lotto.model.domain;

import static lotto.model.constant.LottoPrizeConstant.FIFTH;
import static lotto.model.constant.LottoPrizeConstant.FIRST;
import static lotto.model.constant.LottoPrizeConstant.FOURTH;
import static lotto.model.constant.LottoPrizeConstant.SECOND;
import static lotto.model.constant.LottoPrizeConstant.THIRD;
import static lotto.util.message.ResultMessage.NORMAL_DRAW_RESULT;
import static lotto.util.message.ResultMessage.RESULT_HEADER;
import static lotto.util.message.ResultMessage.RESULT_HEADER_LINE;

public record LottoResult(int first, int second, int third, int fourth, int fifth) {

    public long totalPrize() {
        return (first * FIRST.getPrize()) +
                (second * SECOND.getPrize()) +
                (third * THIRD.getPrize()) +
                (fourth * FOURTH.getPrize()) +
                (fifth * FIFTH.getPrize());
    }

    @Override
    public String toString() {
        String sb = RESULT_HEADER.getMessage()
                + RESULT_HEADER_LINE.getMessage()
                + NORMAL_DRAW_RESULT.normalDrawResult(FIFTH, fifth)
                + NORMAL_DRAW_RESULT.normalDrawResult(FOURTH, fourth)
                + NORMAL_DRAW_RESULT.normalDrawResult(THIRD, third)
                + NORMAL_DRAW_RESULT.secondDrawResult(SECOND, second)
                + NORMAL_DRAW_RESULT.normalDrawResult(FIRST, first);
        return sb;
    }
}
