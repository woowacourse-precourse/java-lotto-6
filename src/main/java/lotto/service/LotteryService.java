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

    public List<Lotto> issueLottery() {
        int amount = Input.readPurchaseAmount();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = Lotto.generateLottery();
            lottos.add(lotto);
        }

        Output.printLotteries(lottos);
        return lottos;
    }

    public void getWinningStatistics() {

    }
}
