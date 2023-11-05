package domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    public Map<String, Integer> checkWinnersCountService(List<List<Integer>> totalLottoTickets, List<Integer> winningNumber, int bonusNumber) {
        Map<String, Integer> resultsCount = new LinkedHashMap<>(); // 변경된 부분

        // 초기 카운트 설정
        resultsCount.put("3개 일치 (5,000원)", 0);
        resultsCount.put("4개 일치 (50,000원)", 0);
        resultsCount.put("5개 일치 (1,500,000원)", 0);
        resultsCount.put("5개 일치, 보너스 볼 일치 (30,000,000원)", 0);
        resultsCount.put("6개 일치 (2,000,000,000원)", 0);


        for (List<Integer> ticket : totalLottoTickets) {
            int matchCount = 0;
            boolean bonusMatch = ticket.contains(bonusNumber);

            for (Integer number : ticket) {
                if (winningNumber.contains(number)) {
                    matchCount++;
                }
            }

            // 6개 일치
            if (matchCount == 6) {
                resultsCount.put("6개 일치 (2,000,000,000원)", resultsCount.get("6개 일치 (2,000,000,000원)") + 1);
            }

            // 5개 번호 + 보너스 번호 일치
            if (matchCount == 5 && bonusMatch) {
                resultsCount.put("5개 일치, 보너스 볼 일치 (30,000,000원)", resultsCount.get("5개 일치, 보너스 볼 일치 (30,000,000원)") + 1);
            }

            // 5개 번호 일치
            if (matchCount == 5 && !bonusMatch) {
                resultsCount.put("5개 일치 (1,500,000원)", resultsCount.get("5개 일치 (1,500,000원)") + 1);
            }

            // 4개 번호 일치
            if (matchCount == 4) {
                resultsCount.put("4개 번호 일치 (50,000원)", resultsCount.get("4개 번호 일치 (50,000원)") + 1);
            }

            // 3개 번호 일치
            if (matchCount == 3) {
                resultsCount.put("3개 일치 (5,000원)", resultsCount.get("3개 일치 (5,000원)") + 1);
            }
        }

        return resultsCount;
    }

}