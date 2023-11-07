package lotto.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.constant.LottoConstant;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandomNumbersGeneratorTest {

    private RandomNumbersGenerator lottoGenerator = new RandomNumbersGenerator();

    @Test
    public void 로또_번호는_오름차순으로_정렬된다() throws Exception {
        // given
        // when
        List<Integer> numbers = lottoGenerator.generate(
                LottoConstant.LOTTO_START_NUMBER,
                LottoConstant.LOTTO_END_NUMBER,
                LottoConstant.LOTTO_NUMBER_COUNT
        );

        //then
        for (int i = 1; i < numbers.size(); ++i) {
            assertThat(numbers.get(i)).isGreaterThan(numbers.get(i - 1));
        }

    }

    @Test
    public void 로또_번호는_6개이다() throws Exception {
        // given
        // when
        List<Integer> numbers = lottoGenerator.generate(
                LottoConstant.LOTTO_START_NUMBER,
                LottoConstant.LOTTO_END_NUMBER,
                LottoConstant.LOTTO_NUMBER_COUNT
        );

        //then
        assertThat(numbers.size()).isEqualTo(LottoConstant.LOTTO_NUMBER_COUNT);

    }

}