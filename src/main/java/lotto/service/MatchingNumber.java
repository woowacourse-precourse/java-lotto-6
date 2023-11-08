package lotto.service;

import lotto.model.LottoTicketEntity;

import java.util.*;

import static lotto.model.AppConstants.lottoMatchingConstants.*;

public class MatchingNumber {
    private Map<String ,Integer> lottoRankList;
    private final List<LottoTicketEntity> lottoTickets;
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public MatchingNumber(List<LottoTicketEntity> lottoTickets, List<Integer> winningNumber, int bonusNumber) {
        lottoRankList = initializeRankMap();
        this.lottoTickets = lottoTickets;
        this.bonusNumber = bonusNumber;
        this.winningNumber = winningNumber;
        getMatchingNumber();
    }
    public void getMatchingNumber() {
        for (LottoTicketEntity lottoTicket : lottoTickets) {
            int matchCount = countMatchingNumbers(lottoTicket.getLottoNumbers());
            int bonusMatchCount = 0;

            if (lottoTicket.getLottoNumbers().contains(bonusNumber)) {
                bonusMatchCount = 1;
            }

            updateRank(matchCount, bonusMatchCount);
        }
    }

    private int countMatchingNumbers(List<Integer> lottoTicket) {
        int count = 0;

        for (Integer lottoNumber : lottoTicket) {
            if (winningNumber.contains(lottoNumber)) {
                count++;
            }
        }

        return count;
    }

    private void updateRank(int matchCount, int bonusMatchCount) {
        String rank = null;

        if(matchCount == 6) {
            rank = MATCHING_6.grade;
        } else if(matchCount == 5 && bonusMatchCount == 1) {
            rank = MATCHING_5_AND_BONUS.grade;
        } else if(matchCount == 5) {
            rank = MATCHING_5.grade;
        } else if(matchCount == 4) {
            rank = MATCHING_4.grade;
        } else if(matchCount == 3) {
            rank = MATCHING_3.grade;
        }

        if(rank != null) {
            lottoRankList.put(rank, lottoRankList.get(rank) + 1);
        }
    }

    private Map<String, Integer> initializeRankMap() {
        Map<String, Integer> ranks = new LinkedHashMap<>();
        ranks.put(MATCHING_3.grade, 0);
        ranks.put(MATCHING_4.grade, 0);
        ranks.put(MATCHING_5.grade, 0);
        ranks.put(MATCHING_5_AND_BONUS.grade, 0);
        ranks.put(MATCHING_6.grade, 0);

        return ranks;
    }
    public Map<String, Integer> getLottoRankList() {
        return lottoRankList;
    }
}
