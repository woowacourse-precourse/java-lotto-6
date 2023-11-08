package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.argument.LottoCompareArgumentsProvider;
import lotto.domain.argument.LottoNumberRangeNotMatchArgumentsProvider;
import lotto.domain.argument.LottoNumberSizeNotMatchArgumentsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("두 로또에 공통으로 있는 번호의 개수를 반환하는 테스트")
    @ParameterizedTest(name = "로또 번호 : {0}, 예상 결과 : {1}")
    @ArgumentsSource(LottoCompareArgumentsProvider.class)
    void compare(final List<Integer> numbers, final int expected) {
        // given
        Lotto lotto = new Lotto(numbers);
        Lotto other = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        long actual = lotto.compare(other);

        // then
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "4, true",
            "5, true",
            "6, true",
            "7, false",
    })
    void contains(final int bonusNumber, boolean expected) {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = LottoNumber.valueOf(bonusNumber);

        // when
        boolean actual = lotto.contains(lottoNumber);

        // then
        assertEquals(expected, actual);
    }
}