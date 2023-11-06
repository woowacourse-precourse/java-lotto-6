package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.DuplicateNumberException;
import lotto.exception.LottoNumberOutOfRangeException;
import lotto.fixtures.LottoNumbersFixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(LottoNumbersFixtures.createDuplicateLottoNumbers()))
                .isInstanceOf(DuplicateNumberException.class);
    }

    @DisplayName("로또 번호의 숫자가 1~45 숫자가 아니라면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {59, 46, 78, 0, -1})
    void lottoNumbersOutOfRange(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(LottoNumberOutOfRangeException.class);

    }

    @Nested
    @DisplayName("로또 번호의 개수가 6개")
    class LottoSize {
        @DisplayName("넘어가면 예외가 발생한다.")
        @Test
        void createLottoByOverSize() {
            assertThatThrownBy(() -> new Lotto(LottoNumbersFixtures.createOverSizeLottoNumbers()))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("미만이라면 예외가 발생한다.")
        @Test
        void createLottoByUnderSize() {
            assertThatThrownBy(() -> new Lotto(LottoNumbersFixtures.createUnderSizeLottoNumbers()))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}