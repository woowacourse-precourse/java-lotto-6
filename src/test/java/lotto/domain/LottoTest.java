package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @DisplayName("유효한 로또 번호를 입력하면 Lotto 클래스의 인스턴스가 생성된다.")
    @Test
    void createLottoByInvalidNumber() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 40);

        // When
        Lotto lotto = new Lotto(numbers);

        // Then
        assertThat(lotto).isNotNull();
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위를 벗어나는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNotInRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 숫자 목록과 로또 번호를 비교해서 일치하는 숫자의 개수를 반환한다.")
    @Test
    void returnMatchedNumberCount() throws Exception {
        // Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> inputNumbers = List.of(1, 2, 3, 4, 12, 43);

        // When
        int count = lotto.countEqualNumbers(inputNumbers);

        // Then
        assertThat(count).isEqualTo(4);
    }

    @DisplayName("입력된 숫자가 로또 번호에 포함되어 있다면 true를 반환한다.")
    @Test
    void returnIsInputNumberContainInLottoNumbers() throws Exception {
        // Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int inputNumber = 4;

        // When
        boolean hasNumber = lotto.hasNumber(inputNumber);

        // Then
        assertThat(hasNumber).isTrue();
    }
}
