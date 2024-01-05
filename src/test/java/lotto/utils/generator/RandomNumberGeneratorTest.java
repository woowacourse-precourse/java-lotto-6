package lotto.utils.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constant.Constant;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {


    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    @DisplayName("랜덤 생성된 숫자 요소는 6개여야 합니다.")
    void sizeTest() {
        final Lotto lotto = randomNumberGenerator.generateLotto();
        final List<Integer> numbers = lotto.getNumbers();
        assertThat(numbers.size()).isEqualTo(Constant.ALLOWED_LOTTO_SIZE);
    }

    @Test
    @DisplayName("랜덤 생성된 숫자 요소는 범위 안에 속해 있어야 합니다.")
    void rangeTest() {
        final Lotto lotto = randomNumberGenerator.generateLotto();
        final List<Integer> numbers = lotto.getNumbers();
        numbers.forEach(number ->
                assertThat(number).isBetween(Constant.ALLOWED_MINIMUM_LOTTO_NUMBER,
                        Constant.ALLOWED_MAXIMUM_LOTTO_NUMBER)
        );
    }
}
