package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoProvider;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;

import java.util.List;

public class LottoMarket {

    private final LottoProvider lottoProvider;

    public LottoMarket(){
        this.lottoProvider = new LottoProvider();
    }

    public List<Lotto> buyLotto(int useMoney){
        return lottoProvider.lottoGenerate(useMoney/1000);
    }

    public WinningLotto winNumberLottoGenerate(List<Integer> numbers, int bonusNumber){
        return lottoProvider.winLottoGenerate(numbers, bonusNumber);
    }

    public int winningsReceive(List<LottoRank> winnings) {
        return lottoProvider.winningsPayments(winnings);
    }
}
