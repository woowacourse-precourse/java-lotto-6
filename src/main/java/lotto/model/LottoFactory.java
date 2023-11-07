package lotto.model;


import java.util.List;

public class LottoFactory {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoFactory(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public Lotto createLotto() {
        List<Integer> numbers = lottoNumberGenerator.generateLottoNumber();
        return new Lotto(numbers);
    }
}
