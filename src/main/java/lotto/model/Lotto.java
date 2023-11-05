package lotto.model;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator lottoValidator = new LottoValidator();
        lottoValidator.validateLotto(numbers);
    }

    public LottoResult matchUp(Lotto givenLotto) {
        AtomicInteger countBall = new AtomicInteger();
        for (Integer number : numbers) {
            if (givenLotto.haveSameBall(number)) {
                countBall.getAndIncrement();
            }
        }
        return LottoResult.getResultByNumberOfBall(countBall.get());
    }

    private boolean haveSameBall(Integer number) {
        return this.numbers.contains(number);
    }
}
