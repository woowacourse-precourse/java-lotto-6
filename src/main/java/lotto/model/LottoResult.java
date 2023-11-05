package lotto.model;

import java.util.List;
import lotto.enums.LottoStatus;

public class LottoResult {
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE_FACTOR = 100;

    private final List<LottoStatus> lottoResult;

    public LottoResult(List<LottoStatus> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public int statusCount(LottoStatus lottoStatus) {
        return (int) lottoResult.stream()
                .filter(status -> status.equals(lottoStatus))
                .count();
    }

    public double caculateProfitRate() {
        long totalPrize = 0;
        for (LottoStatus lottoStatus : lottoResult) {
            totalPrize += lottoStatus.getPrize();
        }
        return ((double) totalPrize / (lottoResult.size() * LOTTO_PRICE)) * PERCENTAGE_FACTOR;
    }

}
