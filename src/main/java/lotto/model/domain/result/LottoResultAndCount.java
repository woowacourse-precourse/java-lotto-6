package lotto.model.domain.result;

public class LottoResultAndCount {
    private final LottoResult lottoResult;
    private final Integer count;

    public LottoResultAndCount(LottoResult lottoResult, Integer count) {
        this.lottoResult = lottoResult;
        this.count = count;
    }

    public Long calculateTotalPrize() {
        return (long) lottoResult.getPrize() * count;
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public Integer getCount() {
        return count;
    }
}
