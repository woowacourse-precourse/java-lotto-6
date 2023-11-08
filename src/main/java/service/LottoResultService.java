package service;

import domain.Lotto;
import domain.LottoResult;
import domain.UserLotto;
import java.math.BigDecimal;
import java.util.List;

public class LottoResultService {

    public LottoResult getLottoResultStatistic(List<Lotto> lottoList, UserLotto userLotto){
        LottoResult lottoResult = new LottoResult();

        for(Lotto lotto : lottoList){
            int equalsLottoCounts = lottoResult.getEqualsLottoCount(lotto.getNumbers(),userLotto);

            lottoResult.setLottoWinning(equalsLottoCounts,lottoResult.isBonusLotto());
        }

        BigDecimal totalProfit = lottoResult.createTotalProfit(lottoResult);
        Double profitRate = lottoResult.createProfitRate(totalProfit ,userLotto.getAmount());

        lottoResult.setTotalProfitAndProfitRate(totalProfit, profitRate);

        return lottoResult;
    }

}
