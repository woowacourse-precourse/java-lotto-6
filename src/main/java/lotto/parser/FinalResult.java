package lotto.parser;
import lotto.model.LottoResult;
public record FinalResult(LottoResult lottoResult) {

    public FinalResult(final LottoResult lottoResult) {
        this.lottoResult = lottoResult;
        sumOfResult();
    }

    private void sumOfResult() {
        this.lottoResult.countingMatchCount();
        this.lottoResult.matchingCount(3);
        this.lottoResult.matchingCount(4);
        this.lottoResult.matchingCount(5);
        this.lottoResult.matchingCount(6);
    }
}
