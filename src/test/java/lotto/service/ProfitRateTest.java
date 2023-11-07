package lotto.service;

import lotto.constant.RankCategory;
import lotto.model.LottoResult;
import lotto.model.ProfitRate;
import lotto.model.LottoPurchaseAmount;
import lotto.service.lotto.LottoResultService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

public class ProfitRateTest{
    @Test
    void calculateProfitRate(){
        EnumMap<RankCategory, Integer> mockResults = new EnumMap<>(RankCategory.class);
        mockResults.put(RankCategory.FIRST,1);
        mockResults.put(RankCategory.SECOND,0);
        mockResults.put(RankCategory.THIRD,0);
        mockResults.put(RankCategory.FOURTH,0);
        mockResults.put(RankCategory.FIFTH,1);
        mockResults.put(RankCategory.NONE,3);

        LottoResult mockLottoResult = new LottoResult(mockResults);
        LottoPurchaseAmount mockPurchaseAmount = new LottoPurchaseAmount(5000);

        LottoResultService lottoResultService = new LottoResultService();
        ProfitRate profitRate = lottoResultService.calculateProfitRate(mockLottoResult,mockPurchaseAmount);

        double expectedRate = ((double) (RankCategory.FIRST.getPrize()*1
                +RankCategory.SECOND.getPrize()*0
                +RankCategory.THIRD.getPrize()*0
                +RankCategory.FOURTH.getPrize()*0
                +RankCategory.FIFTH.getPrize()*1
                +RankCategory.NONE.getPrize()*3)/mockPurchaseAmount.getAmount())*100 ;

        Assertions.assertThat(profitRate.getRate()).isEqualTo(expectedRate);
    }
}
