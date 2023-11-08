package lotto.dto;

import static lotto.constant.LottoRuleConstant.LOTTO_UNIT_PRICE;

import java.util.Map;
import lotto.constant.Ranking;
import lotto.model.LottoResult;
import lotto.model.LottoTickets;

public class LottoResultDto {
    private Map<Ranking, Integer> lottoResult;
    private float returnRate;

    public LottoResultDto(LottoResult lottoResult, int quantity) {
        this.lottoResult = lottoResult.getLottoResult();
        this.returnRate = calReturnRate(lottoResult.getTotalPrizeMoney(), quantity);
    }

    private float calReturnRate(int totalPrizeMoney, int quantity) {
        float purchaseAmount = quantity * LOTTO_UNIT_PRICE;

        return totalPrizeMoney / purchaseAmount * 100;
    }

    public Map<Ranking, Integer> getLottoResult() {
        return lottoResult;
    }

    public float getReturnRate() {
        return returnRate;
    }
}
