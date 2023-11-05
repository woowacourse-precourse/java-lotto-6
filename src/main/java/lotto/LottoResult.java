package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> result = new HashMap<>();
    private final Double profitRate;

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        int totalPrize = 0;
        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lotto.match(winningLotto);
            totalPrize += lottoRank.getPrize();
            result.put(lottoRank, result.getOrDefault(lottoRank, 0) + 1);
        }
        profitRate = (double) totalPrize / (lottos.size() * LottoSalesMachine.lottoPrice);
    }


    public void printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n---\n");
        messagePerLottoRank(sb);
        sb.append("총 수익률은 ")
                .append(String.format("%.2f", profitRate))
                .append("%입니다.");

        System.out.println(sb);
    }

    private void messagePerLottoRank(StringBuilder sb) {
        for (LottoRank lottoRank : LottoRank.values()) {
            sb.append(lottoRank.getMatchCount())
                    .append("개 일치")
                    .append(lottoRank.isBonusMatch() ? ", 보너스 볼 일치" : "")
                    .append(" (")
                    .append(lottoRank.getPrize())
                    .append("원) - ")
                    .append(result.getOrDefault(lottoRank, 0))
                    .append("개\n");
        }
    }
}
