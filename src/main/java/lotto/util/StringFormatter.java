package lotto.util;

import lotto.domain.Lotto;
import lotto.dto.LottoResult;
import lotto.domain.Ranking;

import java.util.List;

public class StringFormatter {

    private static final String LOTTO_FORMAT = "[%s]";
    private static final String DELIMITER = ", ";
    private static final String FIFTH_FORMAT = "3개 일치 (5,000원) - %s개";
    private static final String FOURTH_FORMAT = "4개 일치 (50,000원) - %s개";
    private static final String THIRD_FORMAT = "5개 일치 (1,500,000원) - %s개";
    private static final String SECOND_FORMAT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %s개";
    private static final String FIRST_FORMAT = "6개 일치 (2,000,000,000원) - %s개";
    private static final String YIELD_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final String NEXT_LINE = "\n";

    public String makeLottoLine(Lotto lotto) {
        String line = makeLine(lotto);
        return String.format(LOTTO_FORMAT, line);
    }

    private String makeLine(Lotto lotto) {
        List<String> temp = lotto.numbers().stream()
                .map(String::valueOf)
                .toList();
        return String.join(DELIMITER, temp);
    }

    public String makeResultLines(LottoResult result) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FIFTH_FORMAT, result.getRankingCount(Ranking.FIFTH))).append(NEXT_LINE);
        sb.append(String.format(FOURTH_FORMAT, result.getRankingCount(Ranking.FOURTH))).append(NEXT_LINE);
        sb.append(String.format(THIRD_FORMAT, result.getRankingCount(Ranking.THIRD))).append(NEXT_LINE);
        sb.append(String.format(SECOND_FORMAT, result.getRankingCount(Ranking.SECOND))).append(NEXT_LINE);
        sb.append(String.format(FIRST_FORMAT, result.getRankingCount(Ranking.FIRST))).append(NEXT_LINE);
        sb.append(String.format(YIELD_FORMAT, result.getYield()));
        return sb.toString();
    }
}
