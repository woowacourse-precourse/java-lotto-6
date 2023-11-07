package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoStatus;
import lotto.service.LottoResultDto;

public class LottoResult {
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE_FACTOR = 100;

    private final List<LottoStatus> lottoResult;

    public LottoResult(List<LottoStatus> lottoResult) {
        this.lottoResult = lottoResult;
    }
    public LottoResultDto getLottoResultDto() {
        Map<LottoStatus, Integer> statusCounts = new HashMap<>();

        for (LottoStatus lottoStatus : LottoStatus.values()) {
            int count = statusCount(lottoStatus);
            statusCounts.put(lottoStatus, count);
        }

        return new LottoResultDto(statusCounts);
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
