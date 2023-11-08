package lotto.model.domain.result;

/**
 * 로또의 당첨 결과에 대한 당첨 개수를 저장하는 결과 클래스
 */
public class LottoResultAndCount {
    private final LottoResult lottoResult;
    private final Integer count;

    public LottoResultAndCount(LottoResult lottoResult, Integer count) {
        this.lottoResult = lottoResult;
        this.count = count;
    }

    /**
     * @return - 해당 당첨 결과에 대한 총 상금을 계산한다.
     */
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
