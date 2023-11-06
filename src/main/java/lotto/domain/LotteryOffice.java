package lotto.domain;

import static lotto.domain.Rankings.decideRankings;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;

public class LotteryOffice {

    private static final int FIVE_MATCHES = 5;

    private List<Lotto> issuedLotto;
    private Lotto winningTicket;
    private BonusNumber bonusNumber;

    public LotteryOffice(List<Lotto> issuedLotto, Lotto winningTicket, BonusNumber bonusNumber) {
        this.issuedLotto = issuedLotto;
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public List<Rankings> determineWinning() {
        List<Rankings> winningResult = new ArrayList<>();
        for (Lotto lotto : issuedLotto) {
            winningResult.add(decideRankings(lotto, winningTicket, bonusNumber));
        }
        return winningResult;
    }
}
