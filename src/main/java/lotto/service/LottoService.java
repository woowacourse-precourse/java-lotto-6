package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.Ranks;

public class LottoService {

    private final LottoMachine lottoMachine;
    public LottoService() {
        this.lottoMachine = new LottoMachine();
    }

    public List<Lotto> buyLottery(Integer purchasePrice) {
        List<Lotto> lottery = new ArrayList<>();
        Integer numOfLotto = purchasePrice / 1000;

        for (Integer i = 0; i < numOfLotto; i++) {
            lottery.add(this.lottoMachine.buyLotto());
        }

        return lottery;
    }

    public Ranks lottoResults(List<Lotto> lottery, List<Integer> winningNumber, LottoNumber bonusNumber) {
        return new Ranks(lottery, winningNumber, bonusNumber);
    }

}
