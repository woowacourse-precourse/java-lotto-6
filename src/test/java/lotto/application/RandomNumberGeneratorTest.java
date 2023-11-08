package lotto.application;

import static lotto.enums.LottoConfig.LOTTO_COUNT;
import static lotto.enums.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.enums.LottoConfig.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    @Test
    void 로또_개수만큼_랜덤_숫자를_생성하여_반환한다() {
        // when
        List<Integer> numbers = numberGenerator.generateNumbers();

        // then
        assertThat(numbers).hasSize(LOTTO_COUNT.getValue());
    }

    @RepeatedTest(30)
    void 수십번_반복해도_중복되지_않는_숫자_리스트를_반환한다() {
        // when
        List<Integer> numbers = numberGenerator.generateNumbers();

        // then
        assertThat(numbers).doesNotHaveDuplicates();
    }

    @Test
    void 랜덤으로_생성된_숫자는_로또_숫자_범위를_가진다() {
        // when
        List<Integer> numbers = numberGenerator.generateNumbers();

        // then
        assertThat(numbers).allMatch(
                number -> MIN_LOTTO_NUMBER.getValue() <= number && number <= MAX_LOTTO_NUMBER.getValue()
        );
    }
}
