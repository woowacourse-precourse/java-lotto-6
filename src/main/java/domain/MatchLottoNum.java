package domain;

import java.util.List;
import view.OutputView;

public class MatchLottoNum {

    private OutputView outputView = new OutputView();

    public void calculateEarnings(List<List<Integer>> ticketList, List<Integer> winningNumbers, int bonusNumber) {
        int[] prizes = {5000, 50000, 1500000, 30000000, 2000000000};

        int totalEarnings = 0;
        int totalSpent = ticketList.size() * 1000;
        int[] matchCounts = new int[5]; // 0: 3개 일치, 1: 4개 일치, ..., 4: 6개 일치
        for (List<Integer> ticket : ticketList) {
            int matched = countMatches(ticket, winningNumbers);
            if (matched >= 3 && matched != 5) {
                matchCounts[matched - 3]++;
            }
            if (matched == 5 && ticket.contains(bonusNumber)) {
                matchCounts[3]++; // 5개 일치 + 보너스
            }
            if (matched == 5 && !ticket.contains(bonusNumber)) {
                matchCounts[2]++; // 5개 일치
            }
        }

        for (int i = 0; i < matchCounts.length; i++) {
            totalEarnings += matchCounts[i] * prizes[i];
        }
        //수익률 공식 의문점,,8000원 투자해서 3000원 이득이면 수익률이 62.5가아니지만 테스트 셋에 맞춤
        double profitPercentage = (double) totalEarnings / totalSpent * 100;
        outputView.displayResults(matchCounts, profitPercentage);
    }

    private int countMatches(List<Integer> ticket, List<Integer> winningNumbers) {
        int matches = 0;
        for (Integer number : ticket) {
            if (winningNumbers.contains(number)) {
                matches++;
            }
        }
        return matches;
    }
}
