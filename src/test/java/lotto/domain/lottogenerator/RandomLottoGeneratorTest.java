package lotto.domain.lottogenerator;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.constant.LottoConstant;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoGeneratorTest {

    @DisplayName("임의 값을 가진 로또를 생성한다.")
    @Test
    void createRandomValuesLotto() {
        // given
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();

        // when
        Lotto lotto = randomLottoGenerator.generate();

        // then
        assertThat(lotto.getNumbers().size()).isEqualTo(LottoConstant.LOTTO_NUMBERS_SIZE);
    }
}