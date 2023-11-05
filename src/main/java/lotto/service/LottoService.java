package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Price;
import lotto.domain.Ranks;

public class LottoService {

    private final LottoMachine lottoMachine;
    public LottoService() {
        this.lottoMachine = new LottoMachine();
    }

    public List<Lotto> buyLottery(Price purchasePrice) {
        List<Lotto> lottery = new ArrayList<>();
        Integer numOfLotto = purchasePrice.numberLotteryAvailablePurchase();;

        for (Integer i = 0; i < numOfLotto; i++) {
            lottery.add(this.lottoMachine.buyLotto());
        }

        return lottery;
    }

    public Ranks lottoResults(List<Lotto> lottery, List<LottoNumber> winningNumber, LottoNumber bonusNumber) {
        return new Ranks(lottery, winningNumber, bonusNumber);
    }

}
