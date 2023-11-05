package lotto.result;

public class LottoResult {
    private LottoResultType lottoResultType;

    public LottoResult(LottoResultType lottoResultType) {
        this.lottoResultType = lottoResultType;
    }

    // 수익률 계산
    public double calculateRateOfReturn(int money) {
        double rateOfReturn = 0;

        Long sum = 0L;
        for (LottoResultType type: LottoResultType.values()) {
            sum += type.getPrice() * type.getCount();
        }

        rateOfReturn = sum / money;

        return rateOfReturn;
    }
}
