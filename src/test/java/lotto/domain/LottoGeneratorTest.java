package lotto.domain;

import org.junit.jupiter.api.*;
import lotto.domain.util.SetNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        List<Integer> fixedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        SetNumberGenerator setNumberGenerator = new SetNumberGenerator(fixedNumbers);
        lottoGenerator = new LottoGenerator(3, setNumberGenerator);
    }

    @DisplayName("로또 생성 개수 테스트")
    @Test
    void makeLottos_ShouldGenerateSpecifiedNumberOfLottos() {
        lottoGenerator.makeLottos();
        List<Lotto> lottos = lottoGenerator.getLottos();

        assertThat(lottos).hasSize(3);
    }

    @DisplayName("로또 생성 숫자 테스트")
    @Test
    void makeLottos_LottosShouldContainNumbersFromSetNumberGenerator() {
        lottoGenerator.makeLottos();
        List<Lotto> lottos = lottoGenerator.getLottos();

        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        }
    }

    @DisplayName("로또 리스트 불변 테스트")
    @Test
    void getLottos_ShouldReturnImmutableList() {
        lottoGenerator.makeLottos();
        List<Lotto> lottos = lottoGenerator.getLottos();

        assertThatThrownBy(() -> lottos.add(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
