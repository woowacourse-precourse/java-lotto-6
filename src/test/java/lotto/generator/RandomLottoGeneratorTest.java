package lotto.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constant.LottoConstant;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandomLottoGeneratorTest {

    private RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();

    @Test
    public void 로또_번호는_오름차순으로_정렬된다() throws Exception {
        // given
        Lotto lotto = lottoGenerator.generate();

        // when
        List<Integer> numbers = lotto.getNumbers();

        //then
        for (int i = 1; i < numbers.size(); ++i) {
            assertThat(numbers.get(i)).isGreaterThan(numbers.get(i - 1));
        }

    }

    @Test
    public void 로또_번호는_6개이다() throws Exception {
        // given
        Lotto lotto = lottoGenerator.generate();

        // when
        List<Integer> numbers = lotto.getNumbers();

        //then
        assertThat(numbers.size()).isEqualTo(LottoConstant.LOTTO_NUMBER_COUNT);

    }

}