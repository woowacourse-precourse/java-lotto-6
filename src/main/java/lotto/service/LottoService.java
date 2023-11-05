package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;

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

    public Map<Rank, Integer> matchLotteryWinningNumber(List<Lotto> lottery, List<Integer> winningNumber, Integer bonusNumber) {
        Map<Rank, Integer> resultCount = new HashMap<>();
        for (Lotto lotto : lottery) {
            Rank rank = matchLottoWinningNumber(lotto, winningNumber, bonusNumber);
            resultCount.put(rank, resultCount.getOrDefault(rank, 0) + 1);
        }
        return resultCount;
    }

    private Rank matchLottoWinningNumber(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
        return Rank.valueOf(winningNumbers.size(), lotto.getNumbers().contains(bonusNumber));
    }
}
