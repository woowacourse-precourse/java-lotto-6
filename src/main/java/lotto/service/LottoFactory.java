package lotto.service;


import java.util.List;
import lotto.model.Lotto;

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
