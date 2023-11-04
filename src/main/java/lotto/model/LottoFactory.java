package lotto.model;


import static lotto.exception.ExceptionMessage.RANDOM_NUMBER_GENERATION_ERROR;

import java.util.List;

public class LottoFactory {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoFactory(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public Lotto createLotto() {
        while (true) {
            List<Integer> numbers = lottoNumberGenerator.generateLottoNumber();
            try {
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException (RANDOM_NUMBER_GENERATION_ERROR.getErrorMessage() + e.getMessage());
            }
        }
    }
}
