package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "로또 번호 : {0}")
    @ArgumentsSource(LottoNumberSizeNotMatchArgumentsProvider.class)
    @DisplayName("로또 번호의 갯수가 6개가 아니라면 예외가 발생한다.")
    void createLottoByNotMatchSize(final List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "로또 번호 : {0}")
    @ArgumentsSource(LottoNumberRangeNotMatchArgumentsProvider.class)
    @DisplayName("로또 번호는 1 ~ 45 사이가 아니라면 예외가 발생한다.")
    void createLottoByNotMatchNumberRange(final List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개면서 1 ~ 45 사이의 갑싱고 중복된 숫자가 없으면 정상 생성")
    @Test
    void createLotto() {
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("사용자 로또 번호와 보너스 번호가 중복인 경우 예외 발생 테스트")
    void calculateRankDuplicateExceptionTest(final int bonusNumber) {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto other = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // expected
        assertThrows(IllegalArgumentException.class, () -> lotto.calculateRank(other, bonusNumber));
    }

    @ParameterizedTest(name = "비교 로또 번호 : {0}, 보너스 번호 : {1}, 예상 결과 : {2}")
    @ArgumentsSource(CalculateRankArgumentsProvider.class)
    @DisplayName("두 로또와 보너스 번호를 비교하는 테스트")
    void calculateRankTest(final List<Integer> otherLottoNumbers, final int bonusNumber, final Rank expected) {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto other = new Lotto(otherLottoNumbers);

        // when
        Rank actual = lotto.calculateRank(other, bonusNumber);

        // then
        assertEquals(expected, actual);
    }
}