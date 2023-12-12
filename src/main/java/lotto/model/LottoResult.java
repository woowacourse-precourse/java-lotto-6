package lotto.model;

import lotto.util.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoResult {
    private final List<Integer> lottoResult;

    public LottoResult(){
        /* [0,1,2,3,4,5,6,7] => 각 인덱스는 당첨 번호와 일치하는 개수 7은 보너스 번호 , 숫자는 로또 개수
            예시) 보너스 번호 당첨 회수가 7, 6개 일치가 6개 */
        this.lottoResult = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0));
    }

    public void calculateLottoWinning(LottoBundle lottoBundle, WinningNumber winningNumber){
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
