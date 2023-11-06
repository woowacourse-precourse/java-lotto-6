package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

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
}