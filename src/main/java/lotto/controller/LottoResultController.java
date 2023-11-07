package lotto.controller;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LottoResultController {
    public LottoResult createLottoResult(final List<Lotto> lottoTickets,final LottoDraw lottoDraw){
        List<MatchResult> matchResults = generateMatchResults(lottoTickets,lottoDraw);
        List<LottoRank> lottoRanks = generateLottoRanks(matchResults);
        return LottoResult.of(lottoRanks);
    }
    private List<MatchResult> generateMatchResults(final List<Lotto> lottoTickets, final LottoDraw lottoDraw){
        List<MatchResult> matchResults = new ArrayList<>();
        for(Lotto lottoTicket: lottoTickets){
            matchResults.add(generateMatchResult(lottoTicket,lottoDraw));
        }
        return matchResults;
    }
    private MatchResult generateMatchResult(final Lotto lottoTicket , final LottoDraw lottoDraw){
        List<Integer> ticketNumbers = lottoTicket.getNumbers();
        List<Integer> winningNumbers = lottoDraw.winningLotto().getNumbers();
        int matchCount = countMatchNumber(ticketNumbers,winningNumbers);
        boolean bonusMatch = checkBonusNumber(lottoDraw.bonusNumber(),winningNumbers);
        return new MatchResult(matchCount,bonusMatch);
    }
    private int countMatchNumber(List<Integer>ticketNumbers , List<Integer> winningNumbers){
        int count = 0;
        for (Integer ticketNumber : ticketNumbers){
            if (winningNumbers.contains(ticketNumber)){
                count++;
            }
        }
        return count;
    }
    private boolean checkBonusNumber(int bonusNumber , List<Integer> winningNumbers){
        return winningNumbers.contains(bonusNumber);
    }
    private List<LottoRank> generateLottoRanks(List<MatchResult>matchResults){
        List<LottoRank> lottoRanks = new ArrayList<>();
        for (MatchResult matchResult : matchResults){
            lottoRanks.add(LottoRank.determineRankByMatchResult(matchResult));
        }
        return lottoRanks;
    }
}

