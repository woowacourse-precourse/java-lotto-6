package lotto.service;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoDraw;
import lotto.domain.lotto.LottoPaper;
import lotto.domain.lotto.enums.LottoRank;
import lotto.domain.result.LottoResult;
import lotto.domain.result.MatchResult;

import java.util.ArrayList;
import java.util.List;

public class LottoResultService {
    public LottoResult createLottoResult(
            final LottoPaper lottoPaper,
            final LottoDraw lottoDraw
    ) {
        final List<Lotto> lottoTickets = lottoPaper.lottoTickets();

        List<MatchResult> matchResults = generateMatchResults(lottoTickets, lottoDraw);
        List<LottoRank> lottoRanks = generateLottoRanks(matchResults);
        LottoResult lottoResult = LottoResult.of(lottoRanks);

        return lottoResult;
    }

    private List<MatchResult> generateMatchResults(
            final List<Lotto> lottoTickets,
            final LottoDraw lottoDraw
    ) {
        List<MatchResult> matchResults = new ArrayList<>();
        for (Lotto lottoTicket : lottoTickets) {
            matchResults.add(generateMatchResult(lottoTicket, lottoDraw));
        }
        return matchResults;
    }

    private List<LottoRank> generateLottoRanks(List<MatchResult> matchResults) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        for (MatchResult matchResult : matchResults) {
            lottoRanks.add(LottoRank.determineRankByMatchResult(matchResult));
        }
        return lottoRanks;
    }

    private MatchResult generateMatchResult(final Lotto lottoTicket, final LottoDraw lottoDraw) {
        List<Integer> ticketNumbers = lottoTicket.getNumbers();
        List<Integer> winningNumbers = lottoDraw.winningLotto().getNumbers();
        int bonusNumber = lottoDraw.bonusNumber();

        int matchCount = countMatchNumber(ticketNumbers, winningNumbers);
        boolean bonusMatch = checkBonusNumber(bonusNumber, ticketNumbers);

        return new MatchResult(matchCount, bonusMatch);
    }

    private int countMatchNumber(List<Integer> ticketNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer ticketNumber : ticketNumbers) {
            if (winningNumbers.contains(ticketNumber)) {
                count++;
            }
        }
        return count;
    }

    private boolean checkBonusNumber(int bonusNumber, List<Integer> ticketNumbers) {
        return ticketNumbers.contains(bonusNumber);
    }
}
