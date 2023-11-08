package lotto.domain;

import java.util.List;

public class Customer {
    private final Money money;
    private final Lottos lottos;

    public Customer(Money money, Lottos lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public LottoResult getLottoResult(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        List<LottoRank> lottoRanks = lottos.findLottoRanks(winningNumbers, bonusNumber);
        return calculateLottoResult(lottoRanks);
    }

    private LottoResult calculateLottoResult(List<LottoRank> lottoRanks) {
        LottoResult lottoResult = LottoResult.create();
        lottoResult.addLottoRankCount(lottoRanks);
        return lottoResult;
    }

    public Money getMoney() {
        return money;
    }
}
