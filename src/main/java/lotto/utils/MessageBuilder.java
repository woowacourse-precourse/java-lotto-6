package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Player;
import lotto.enums.Ranking;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MessageBuilder {
    private final static int SCALE = 1, EXCEPT_BLANK = 1;
    private final static RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    private MessageBuilder() {

    }

    public static String build(Player player) {
        Lottos lottos = player.getLottos();

        StringBuilder result = new StringBuilder(String.valueOf(lottos.getSize()))
                .append("개를 구매했습니다.")
                .append(System.lineSeparator());

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            Collections.sort(lottoNumbers);
            result.append(lottoNumbers).append(System.lineSeparator());
        }

        return result.toString();
    }

    public static String build(Player player, LottoResult lottoResult) {
        Map<Ranking, Integer> rankingCounts = lottoResult.getRankingCounts();
        BigDecimal prizeRate = lottoResult.calculatePrizeRate(player.getMoney(), SCALE, ROUNDING_MODE);

        StringBuilder result = new StringBuilder("당첨 통계").append(System.lineSeparator())
                .append("---").append(System.lineSeparator());

        Ranking[] values = Ranking.values();
        for (int i = EXCEPT_BLANK; i < values.length; i++) {
            result.append(values[i].getResult()).append(rankingCounts.get(values[i])).append("개").append(System.lineSeparator());
        }

        result.append("총 수익률은 ").append(prizeRate.toPlainString()).append("%입니다.");

        return result.toString();
    }
}
