package lotto.Service.ProfitRateService;

import java.util.List;
import java.util.Map;
import lotto.Model.Lotto.Lotto;
import lotto.Model.LottoWinningResult.LottoWinningResult;
import lotto.Model.ProfitRate.ProfitRate;
import lotto.Model.WinningNumber.WinningNumber;

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
                    return lottoList.size() *  getMultiplier(matchingNumbers);
                })
                .mapToInt(Integer::intValue)
                .sum();
    }

    private int getMultiplier( int matchingNumber){
        if( matchingNumber == 3) {
            return 5000;
        }
        if( matchingNumber == 4) {
            return 50000;
        }
        if( matchingNumber == 5) {
            return 1500000;
        }
        if( matchingNumber == 6) {
            return 2000000000;
        }
        if( matchingNumber == 7) {
            return 30000000;
        }
        return 0;
    }
}
