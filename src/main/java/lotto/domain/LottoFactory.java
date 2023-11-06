package lotto.domain;

public class LottoFactory {

    private final NumberGenerator numberGenerator;

    public LottoFactory(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lotto create() {
        return new Lotto(
                numberGenerator.generate(
                        Lotto.LOTTO_NUMBER_MIN,
                        Lotto.LOTTO_NUMBER_MAX,
                        Lotto.LOTTO_NUMBER_SIZE
                )
        );
    }
}
