package lotto.dto;

import static lotto.constant.LottoRanking.FIFTH;
import static lotto.constant.LottoRanking.FIRST;
import static lotto.constant.LottoRanking.FOURTH;
import static lotto.constant.LottoRanking.SECOND;
import static lotto.constant.LottoRanking.THIRD;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.constant.LottoRanking;

public record WinningStatistics(Map<LottoRanking, Integer> lottoResults) {
    private static final DecimalFormat decimalFormat = new DecimalFormat("#,##0");

    @Override
    public String toString() {
        return String.format("""
                        %d개 일치 (%s원) - %d개
                        %d개 일치 (%s원) - %d개
                        %d개 일치 (%s원) - %d개
                        %d개 일치, 보너스 볼 일치 (%s원) - %d개
                        %d개 일치 (%s원) - %d개""",
                FIFTH.getSameCount(), decimalFormat.format(FIFTH.getPrize()), lottoResults.get(FIFTH),
                FOURTH.getSameCount(), decimalFormat.format(FOURTH.getPrize()), lottoResults.get(FOURTH),
                THIRD.getSameCount(), decimalFormat.format(THIRD.getPrize()), lottoResults.get(THIRD),
                SECOND.getSameCount(), decimalFormat.format(SECOND.getPrize()), lottoResults.get(SECOND),
                FIRST.getSameCount(), decimalFormat.format(FIRST.getPrize()), lottoResults.get(FIRST)
        );
    }
}
