package lotto.service;

import java.util.List;
import lotto.domain.LotteryOperator;

public class ApplyWinningLotteryService {
    private final LotteryOperator operator;

    public ApplyWinningLotteryService(LotteryOperator operator) {
        this.operator = operator;
    }

    public void drawWinningLottery(List<Integer> winningNumbers, int bonusNumber) {
        operator.draw(winningNumbers, bonusNumber);
    }

}
