package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Nested
    @DisplayName("로또 번호의 개수가 6개")
    class LottoSize {
        @DisplayName("넘어가면 예외가 발생한다.")
        @Test
        void createLottoByOverSize() {
            LottoNumbers lottoNumbers = new LottoNumbers();
            assertThatThrownBy(() -> new Lotto(lottoNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("미만이라면 예외가 발생한다.")
        @Test
        void createLottoByUnderSize() {
            LottoNumbers lottoNumbers = new LottoNumbers();
            assertThatThrownBy(() -> new Lotto(lottoNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.add(new LottoNumber(10));
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(40));
        lottoNumbers.add(new LottoNumber(35));
        lottoNumbers.add(new LottoNumber(17));
        lottoNumbers.add(new LottoNumber(10));

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(DuplicateNumberException.class);
    }

    @DisplayName("로또 번호의 숫자가 1~45 숫자가 아니라면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {59,46,78,0,-1})
    void lottoNumbersOutOfRange(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(LottoNumberOutOfRangeException.class);

    }
}