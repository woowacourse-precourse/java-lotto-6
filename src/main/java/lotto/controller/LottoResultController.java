package lotto.controller;

import lotto.domain.*;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoResultController {
    public LottoResult createLottoResult(LottoPaper lottoPaper,LottoDraw lottoDraw){
        final List<Lotto> lottoTickets = lottoPaper.lottoTickets();
        List<MatchResult> matchResults = generateMatchResults(lottoTickets,lottoDraw);
        List<LottoRank> lottoRanks = generateLottoRanks(matchResults);
        LottoResult lottoResult = LottoResult.of(lottoRanks);
        OutputView.printLottoResultMessage(lottoResult);
        return lottoResult;
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
        boolean bonusMatch = checkBonusNumber(lottoDraw.bonusNumber(),ticketNumbers);
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
    private boolean checkBonusNumber(int bonusNumber , List<Integer> ticketNumbers){
        return ticketNumbers.contains(bonusNumber);
    }
    private List<LottoRank> generateLottoRanks(List<MatchResult>matchResults){
        List<LottoRank> lottoRanks = new ArrayList<>();
        for (MatchResult matchResult : matchResults){
            lottoRanks.add(LottoRank.determineRankByMatchResult(matchResult));
        }
        return lottoRanks;
    }
}

