package lotto.LottoController;
import lotto.Lotto;

import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;


public class NumberFormatter {

    public Map<String, Integer> formatResult(Map<Lotto.LottoRank, Integer> result){
        Map<String, Integer> formattedResult = new LinkedHashMap<>();

        for(int i = Lotto.LottoRank.values().length - 2; i >=0; i--){
            Lotto.LottoRank rank = Lotto.LottoRank.values()[i];
            String showRank = showFormatter(rank);
            formattedResult.put(showRank, result.getOrDefault(rank, 0));
        }
        return formattedResult;
    }

    private String showFormatter(Lotto.LottoRank rank){
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        String prizeFomatted = numberFormat.format(rank.getPrize());
        if(rank == Lotto.LottoRank.SECOND){
            return rank.getMatchCount() + "개 일치, 보너스 볼 일치 (" + prizeFomatted + "원)";
        }
        else{
            return rank.getMatchCount() + "개 일치 (" + prizeFomatted + "원)";
        }
    }
}
