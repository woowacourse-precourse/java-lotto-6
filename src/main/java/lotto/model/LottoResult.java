package lotto.model;

import lotto.util.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoResult {
    private final List<Integer> lottoResult;
    private final LottoBundle lottoBundle;
    private final WinningNumber winningNumber;

    public LottoResult(LottoBundle lottoBundle, WinningNumber winningNumber){
        this.lottoBundle = lottoBundle;
        this.winningNumber = winningNumber;
        // 7 => 5개 일치, 보너스 볼 일치
        this.lottoResult = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0));
        calculateLottoWinning();
    }

    private void calculateLottoWinning(){
        List<Integer> bundleResult = lottoBundle.calculateWinningNumbers(
                winningNumber.getWinningNumber(), winningNumber.getBonusNumber());

        for(Integer ticketResult: bundleResult){
            lottoResult.set(ticketResult, lottoResult.get(ticketResult) + 1);
        }
    }

    public List<Integer> getLottoResult(){
        return lottoResult;
    }

    public Double getReturnRate(Integer money){
        Integer total = LottoPrice.ThreeMatch.getPrice() * lottoResult.get(Config.threeMatch)
                + LottoPrice.FourMatch.getPrice() * lottoResult.get(Config.fourMatch)
                + LottoPrice.FiveMatch.getPrice() * lottoResult.get(Config.fiveMatch)
                + LottoPrice.BonusMatch.getPrice() * lottoResult.get(Config.bonusMatch)
                + LottoPrice.SixMatch.getPrice() * lottoResult.get(Config.sixMatch);

        return ((double)(total - money) / money) * 100 + 100;
    }
}
