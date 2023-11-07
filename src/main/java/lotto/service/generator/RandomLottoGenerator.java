package lotto.service.generator;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;

public class RandomLottoGenerator implements LottoGenerator {
    private final NumbersGenerator numbersGenerator;

    public RandomLottoGenerator(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    @Override
    public List<LottoBall> generate() {
        return numbersGenerator.generateSortedUniqueNumbersInRange(
                        LottoBall.MIN_RANGE,
                        LottoBall.MAX_RANGE,
                        Lotto.LOTTO_BALL_COUNT)
                .stream()
                .map(LottoBall::getInstance)
                .toList();
    }
}
