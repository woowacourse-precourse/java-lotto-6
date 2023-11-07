package lotto.LottoController;

import lotto.LottoModel.LottoRank;

import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class NumberFormatter {

    public Map<String, Integer> formatResult(Map<LottoRank, Integer> result) {
        Map<String, Integer> formattedResult = new LinkedHashMap<>();

        for (int i = LottoRank.values().length - 2; i >= 0; i--) {
            LottoRank rank = LottoRank.values()[i];
            String showRank = showFormatter(rank);

            formattedResult.put(showRank, result.getOrDefault(rank, 0));
        }
        return formattedResult;
    }

    private String showFormatter(LottoRank rank) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        String prizeFormatted = numberFormat.format(rank.getPrize());

        if (rank == LottoRank.SECOND) {
            return rank.getMatchCount() + "개 일치, 보너스 볼 일치 (" + prizeFormatted + "원)";
        }
        return rank.getMatchCount() + "개 일치 (" + prizeFormatted + "원)";
    }
}
