package lotto.service;

import lotto.model.LottoTicketEntity;

import java.util.*;

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
        int rank = 0;
        if(matchCount == 6) {
            rank = 1;
        } else if(matchCount == 5 && bonusMatchCount == 1) {
            rank = 2;
        } else if(matchCount == 5) {
            rank = 3;
        } else if(matchCount == 4) {
            rank = 4;
        } else if(matchCount == 3) {
            rank = 5;
        }

        if(rank > 0) {
            String rankKey = rank + "등";
            lottoRankList.put(rankKey, lottoRankList.get(rankKey) + 1);
        }
    }

    private Map<String, Integer> initializeRankMap() {
        Map<String, Integer> ranks = new LinkedHashMap<>();
        lottoRankList.put("1등", 0);
        lottoRankList.put("2등", 0);
        lottoRankList.put("3등", 0);
        lottoRankList.put("4등", 0);
        lottoRankList.put("5등", 0);
        return ranks;
    }
    public Map<String, Integer> getLottoRankList() {
        return lottoRankList;
    }
}
