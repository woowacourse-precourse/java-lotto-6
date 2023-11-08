package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.utils.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    @DisplayName("로또 번호를 생성할 수 있다.")
    @Test
    void generateNumbers_Success() {
        List<Integer> numbers = LottoGenerator.generateNumbers();

        assertThat(numbers).hasSize(Constants.LOTTO_NUM_COUNT);
        assertThat(numbers).allMatch(number -> number >= Constants.LOTTO_NUM_MIN && number <= Constants.LOTTO_NUM_MAX);
        assertThat(numbers).doesNotHaveDuplicates();
    }

    @DisplayName("로또를 여러 개 생성할 수 있다.")
    @Test
    void createLottos_Success() {
        int count = 7;
        List<Lotto> lottos = LottoGenerator.createLottos(count);

        assertThat(lottos).hasSize(count);
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(Constants.LOTTO_NUM_COUNT);
            assertThat(lotto.getNumbers()).allMatch(
                    number -> number >= Constants.LOTTO_NUM_MIN && number <= Constants.LOTTO_NUM_MAX);
            assertThat(lotto.getNumbers()).doesNotHaveDuplicates();
        }
    }
}
