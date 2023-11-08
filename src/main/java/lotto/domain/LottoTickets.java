package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.view.Messages;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int getSizeOfLottoTickets() {
        return lottoTickets.size();
    }

    public List<Ranking> calculateRanking(final WinningLotto winningLotto) {
        List<Ranking> result = new ArrayList<>();

        for (LottoTicket lottoTicket : this.lottoTickets) {
            int matchCount = lottoTicket.calculateMatchCount(winningLotto);
            boolean bonusNumberMatched = lottoTicket.containsBonusNumber(winningLotto);

            Ranking ranking = Ranking.findRankingWithResult(matchCount, bonusNumberMatched);

            if (ranking != null) {
                result.add(ranking);
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (LottoTicket lottoTicket : lottoTickets) {
            stringBuilder.append(lottoTicket.toString());
            stringBuilder.append(Messages.NEW_LINE);
        }

        return stringBuilder.toString();
    }
}
