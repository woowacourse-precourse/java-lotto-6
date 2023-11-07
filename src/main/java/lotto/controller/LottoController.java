package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lottery;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Price;

public class LottoController {

    private final LottoMachine lottoMachine;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
    }

    public Lottery buyLottery(Price purchasePrice) {
        List<Lotto> lottery = new ArrayList<>();
        Integer numOfLotto = purchasePrice.numberAvailableForPurchase();;

        for (Integer i = 0; i < numOfLotto; i++) {
            lottery.add(this.lottoMachine.buyLotto());
        }

        return new Lottery(lottery);
    }
}
