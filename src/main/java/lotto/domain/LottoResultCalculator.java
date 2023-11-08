package lotto.domain;

import lotto.LottoTicket;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoResultCalculator {
    public LottoResultCalculator() {
    }

    public List<Integer> summarizeLottoResults() {
        List<Integer> rankwiseTicketCounts = new ArrayList<>(); // 등수별 결과 저장
        List<Integer> lottoResult = new ArrayList<>();
        lottoResult = LottoTicket.getLottoResult(); // 당첨 결과 오름차순 정리
        for (int matchcount = 0; matchcount <= 7; matchcount++) {
            rankwiseTicketCounts.add(countWinningTicketsByRank(lottoResult, matchcount));
        }
        System.out.println(rankwiseTicketCounts);
        return rankwiseTicketCounts;
    }
    public int countWinningTicketsByRank(List<Integer> lottoResult, int matchCount) { // 전달받은 등수에 몇장의 로또티켓이 당첨되었는지 확인
        int winningCount = 0;
        for (int count : lottoResult) {
            if (count == matchCount)
                winningCount++;
        }
        return winningCount;
    }

    public String calculateTotalYield(List<Integer> lottoResult, int purchaseAmount) {
        List<Integer> prizesPerRank = Arrays.asList(5000, 50000, 1500000, 30000000, 2000000000); // 등수별 상금
        int totalPrizeAmount = 0; // 총 당첨금
        int currentRank = 3; // 일치 번호 3개 이상부터 상금 지급
        for (int currentPrize : prizesPerRank) {
            totalPrizeAmount += lottoResult.get(currentRank) * currentPrize;
            currentRank++;
        }
        double totalYield = totalPrizeAmount / purchaseAmount * 100;
        DecimalFormat df = new DecimalFormat("#.##");

        return df.format(totalYield);
    }
}
