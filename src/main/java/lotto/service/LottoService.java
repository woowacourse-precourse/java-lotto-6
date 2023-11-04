package lotto.service;

import lotto.Lotto;
import lotto.domain.LottoAwards;
import lotto.domain.Member;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final LottoMachine lottoMachine;

    public LottoService(final LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> purchase(int money) {
        return lottoMachine.roulette(money);
    }
    public List<Rank> awards(final Member member, final WinningNumber winningNumber) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : member.getLottos()) {
            Rank rank = LottoAwards.awards(lotto, winningNumber);
            ranks.add(rank);
        }
        return ranks;
    }

}
