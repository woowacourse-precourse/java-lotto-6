package lotto.dto.calculate;

public class GetReturnRateDto {
    private final double lottoReturnRate;

    public GetReturnRateDto(double lottoReturnRate) {
        this.lottoReturnRate = lottoReturnRate;
    }
    private final double getLottoReturnRate(){
        return this.lottoReturnRate;
    }
    public double lottoReturnRate(){
        return getLottoReturnRate();
    }
}
