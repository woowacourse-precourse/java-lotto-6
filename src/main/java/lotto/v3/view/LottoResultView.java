package lotto.v3.view;

import lotto.v3.model.LottoRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoResultView {
    public void displayResults(Map<LottoRank, Integer> matchCounts) {
        System.out.println("당첨 통계");
        System.out.println("---");

        // 원하는 출력 순서로 LottoRank 값들을 List에 추가
        List<LottoRank> sortedRanks = new ArrayList<>();
        sortedRanks.add(LottoRank.FIFTH);
        sortedRanks.add(LottoRank.FOURTH);
        sortedRanks.add(LottoRank.THIRD);
        sortedRanks.add(LottoRank.SECOND);
        sortedRanks.add(LottoRank.FIRST);

        // 정렬된 순서대로 결과 출력
        for (LottoRank rank : sortedRanks) {
            String result = String.format("%d개 일치", rank.getMatchCount());
            if(rank.isBonusMatch()) {
                result += ", 보너스 볼 일치";
            }
            result += String.format(" (%s원) - %d개\n", formatCurrency(rank.getPrizeMoney()), matchCounts.getOrDefault(rank, 0));
            System.out.print(result);
        }
    }

    private String formatCurrency(long amount) {
        return String.format("%,d", amount);
    }
}

