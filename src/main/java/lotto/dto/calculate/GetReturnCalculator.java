package lotto.dto.calculate;

public class GetReturnCalculator {
    private final double lottoReturnRate;

    public GetReturnCalculator(double lottoReturnRate) {
        this.lottoReturnRate = lottoReturnRate;
    }
    private final double getLottoReturnRate(){
        return this.lottoReturnRate;
    }
    public double lottoReturnRate(){
        return getLottoReturnRate();
    }
}
