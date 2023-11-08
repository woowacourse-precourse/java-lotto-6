package lotto.domain;

import java.util.Arrays;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.exception.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_COUNT_ERROR.getMessage());
    }

    @DisplayName("로또 번호의 개수가 6개가 안되면 예외가 발생한다.")
    @Test
    void createLottoBySubSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_COUNT_ERROR.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_DUPLICATED_ERROR.getMessage());
    }

    @DisplayName("로또 번호에 범위에 맞지 않는 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = { 0, 46 })
    void createLottoByInvalidNumber(int invalidNumber) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, invalidNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_RANGE_ERROR.getMessage());
    }

    @DisplayName("로또 생성 성공 테스트")
    @Test
    void createValidLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 숫자 반환 컬렉션 값 변경 예외 테스트")
    @Test
    public void testGetNumbersReturnsUnmodifiableList() {
        List<Integer> validLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validLottoNumbers);

        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> numbers.add(7))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
