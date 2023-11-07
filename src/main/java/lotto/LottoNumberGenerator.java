package lotto;

public class LottoNumberGenerator {
    private static LottoNumberGenerator lottoNumberGenerator;

    private LottoNumberGenerator() {}

    public static LottoNumberGenerator getLottoNumberGenerator() {
        if (lottoNumberGenerator == null) {
            lottoNumberGenerator = new LottoNumberGenerator();
        }
        return lottoNumberGenerator;
    }

}
