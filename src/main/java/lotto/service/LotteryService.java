package lotto.service;

import lotto.domain.Lotto;
import lotto.utils.Input;
import lotto.utils.Output;

import java.util.ArrayList;
import java.util.List;

public class LotteryService {
    private Lotto winningLottery;

    public void setWinningLottery() {
        this.winningLottery = Input.readLottery();
    }

}
