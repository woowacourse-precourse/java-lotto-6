package lotto.model.strategy;

import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.WinningLotto;
import lotto.model.lotto.LottoRank;

public class MyLottoStrategy implements LottoStrategy {

    @Override
    public LottoRank determineRank(LottoTicket lottoTicket, WinningLotto winningLotto, BonusNumber bonusNumber) {
        return lottoTicket.getLottoTicket()
                .stream()
                .map(lotto -> determineLottoRank(lotto, winningLotto, bonusNumber))
                .filter(rank -> rank != LottoRank.FAIL)
                .findFirst()
                .orElse(LottoRank.FAIL);
    }

    private LottoRank determineLottoRank(Lotto lotto, WinningLotto winningLotto, BonusNumber bonusNumber) {
        int matchCount = getmatchingNumbers(lotto, winningLotto);
        boolean matchBonus = hasBonusNumber(lotto, bonusNumber);
        return LottoRank.valueOf(matchCount, matchBonus);
    }

    private int getmatchingNumbers(Lotto lotto, WinningLotto winningLotto) {
        return (int) lotto.getLotto().stream().filter(winningLotto.getLotto()::contains).count();
    }

    private boolean hasBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.getLotto().contains(bonusNumber.getValue());
    }

}
