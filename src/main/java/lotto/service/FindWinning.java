package lotto.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.Controller.PrintScreen;
import lotto.Controller.Request;
import lotto.Lotto;
import lotto.service.generator.RateofReturn;
import lotto.vo.buy.LottoBuy;
import lotto.vo.winning.LottoWinning;

public class FindWinning {
    PrintScreen print = new PrintScreen();
    Request request = new Request();

    private Winning Match(Lotto Lottonumber) {
        int matchwinningcountnumber = Lottonumber.countMatch(LottoWinning.GetWinningNumber());
        boolean matchbonusnumber = Lottonumber.containNumber(LottoWinning.GetBonusNumber());
        return Winning.valueOf(matchwinningcountnumber, matchbonusnumber);
    }

    private Map<Winning, Integer> SetResult() {
        Map<Winning, Integer> result = new LinkedHashMap<>();
        for (Winning Winning : Winning.values()) {
            result.put(Winning, 0);
        }
        return result;
    }

    private Map<Winning, Integer> WinningCalculate(List<Lotto> lottos, FindWinning winninglotto) {
        Map<Winning, Integer> result = SetResult();
        Winning winning;
        for (Lotto lotto : lottos) {
            winning = winninglotto.Match(lotto);
            result.put(winning, result.get(winning) + 1);
        }
        return result;
    }

    private void PrintWinningStatistics(Map<Winning, Integer> result) {
        for (int i = Winning.values().length - 1; i >= 0; i--) {
            Winning.values()[i].PrintWinnging(result.get(Winning.values()[i]));
        }
    }

    private void WinningPriceTotal(Map<Winning, Integer> result) {
        long totalprice = 0;
        for (Winning winning : result.keySet()) {
            totalprice += (winning.GetWinningPrize()) * (result.get(
                    winning));
        }
        LottoWinning.setTotalWinningPrice(totalprice);
    }

    public void Result(List<Lotto> lottos, FindWinning winninglotto) {

        print.StartPrintWinningStatistics();
        Map<Winning, Integer> result = WinningCalculate(lottos, winninglotto);
        PrintWinningStatistics(result);
        WinningPriceTotal(result);
    }

    public void FindLottoWinning(List<Lotto> lottos, FindWinning winninglotto) {
        request.RequestSetWinningNumber();
        Result(lottos, winninglotto);
        RateofReturn.CalculateRateOfReturn(LottoWinning.GetTotalWinningPrice(), LottoBuy.GetBuyMoney());
    }
}
