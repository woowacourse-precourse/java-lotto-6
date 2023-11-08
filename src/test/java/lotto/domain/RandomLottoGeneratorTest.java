package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoGeneratorTest {

    @Test
    void RandomLottoGenerator_객체_생성() {
        assertThat(RandomLottoGenerator.create())
                .isInstanceOf(LottoGenerator.class);
    }

    @Test
    void 로또_번호_6개를_생성한다() {
        assertThat(RandomLottoGenerator.create()
                .generate()
                .getNumbers()
                .size())
                .isEqualTo(6);
    }

    @Test
    void 로또_번호는_오름차순으로_생성한다() {
        var numbers = RandomLottoGenerator.create()
                .generate()
                .getNumbers();
        var expected = numbers.stream()
                .sorted()
                .toList();
        assertThat(numbers)
                .isEqualTo(expected);
    }
}
