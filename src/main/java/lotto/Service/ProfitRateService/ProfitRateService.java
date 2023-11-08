package lotto.Service.ProfitRateService;

import java.util.List;
import java.util.Map;
import lotto.Common.LottoValue;
import lotto.Model.Lotto.Lotto;
import lotto.Model.LottoWinningResult.LottoWinningResult;
import lotto.Model.ProfitRate.ProfitRate;
import static lotto.Common.LottoValue.*;

import static lotto.Common.LottoValue.*;

public class ProfitRateService {
    private  LottoWinningResult lottoWinningResult;

    public ProfitRateService(){
    }

    public ProfitRate calculateProfit(LottoWinningResult lottoWinningResult){
        this.lottoWinningResult = lottoWinningResult;

        Map<Integer, List<Lotto>> winningResult = lottoWinningResult.getMatchingResults();

        int totalLottoCount = winningResult.values().stream()
                .mapToInt(List::size)
                .sum();

        int totalProfit = calculateTotalProfit(winningResult);

        double profitPercentage = ((double) totalProfit / (totalLottoCount * LOTTO_ONE_TICKET_PRICE.getValue()) * 1000);

        profitPercentage = Math.round(profitPercentage * 100.0) / 100.0;

        return new ProfitRate(profitPercentage);
    }

    private int calculateTotalProfit(Map<Integer, List<Lotto>> winningResult){
        return winningResult.entrySet().stream()
                .map(entry -> {
                    int matchingNumbers = entry.getKey();
                    List<Lotto> lottoList = entry.getValue();
                    return lottoList.size() * LottoValue.getMultiplier(matchingNumbers);
                })
                .mapToInt(Integer::intValue)
                .sum();
    }


}
