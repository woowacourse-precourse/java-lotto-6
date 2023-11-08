package lotto.domain;

import static lotto.domain.util.Constant.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.domain.numbergenerator.NumberGenerator;
import lotto.domain.util.SetNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        List<Integer> fixedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numberGenerator = new SetNumberGenerator(fixedNumbers);
    }

    @DisplayName("로또 생성 개수 테스트")
    @Test
    void generate_ShouldGenerateSpecifiedNumberOfLottos() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos = lottoGenerator.generate(3000, numberGenerator);

        assertThat(lottos).hasSize(3000 / LOTTO_PRICE);
    }

    @DisplayName("로또 생성 숫자 테스트")
    @Test
    void generate_LottosShouldContainNumbersFromSetNumberGenerator() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos = lottoGenerator.generate(3000, numberGenerator);

        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).containsExactlyInAnyOrderElementsOf(Arrays.asList(1, 2, 3, 4, 5, 6));
        }
    }

    @DisplayName("로또 리스트 불변 테스트")
    @Test
    void generate_ShouldReturnImmutableList() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos = lottoGenerator.generate(3000, numberGenerator);

        assertThatThrownBy(() -> lottos.add(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
