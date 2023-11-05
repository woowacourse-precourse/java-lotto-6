package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        // given
        List<Integer> givenNumbers = List.of(1, 2, 3, 4, 5);
        // when

        // then
        assertThatThrownBy(() -> new Lotto(List.copyOf(givenNumbers)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호의 개수가 6개가 아닙니다.");
    }

    @DisplayName("로또 번호의 개수가 6개이면 예외가 발생하지 않는다.")
    @Test
    void createLottoBySize() {
        // given
        List<Integer> givenNumbers = List.of(1, 2, 3, 4, 5, 6);
        // when

        // then
        assertThatCode(() -> new Lotto(List.copyOf(givenNumbers)))
                .doesNotThrowAnyException();
    }
    
    @DisplayName("로또 번호에 중복된 숫자가 없으면 예외가 발생하지 않는다.")
    @Test
    void createLottoByNonDuplicatedNumber() {
        // given
        List<Integer> givenNumbers = List.of(1, 2, 3, 4, 5, 6);
        // when

        // then
        assertThatCode(() -> new Lotto(List.copyOf(givenNumbers)))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호에 1에서 45 사이의 숫자보다 큰 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNumberRange() {
        // given
        List<Integer> givenNumbers = List.of(1, 2, 3, 4, 5, 46);
        // when

        // then
        assertThatThrownBy(() -> new Lotto(List.copyOf(givenNumbers)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1에서 45 사이의 숫자만 가능합니다.");
    }

    @DisplayName("로또 번호에 1에서 45 사이의 숫자보다 작은 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNumberRange2() {
        // given
        List<Integer> givenNumbers = List.of(1, 2, 3, 4, 5, 0);
        // when

        // then
        assertThatThrownBy(() -> new Lotto(List.copyOf(givenNumbers)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1에서 45 사이의 숫자만 가능합니다.");
    }

    @DisplayName("로또 번호에 1에서 45 사이의 숫자만 있으면 예외가 발생하지 않는다.")
    @Test
    void createLottoByNumberRange3() {
        // given
        List<Integer> givenNumbers = List.of(1, 2, 3, 4, 5, 45);
        // when

        // then
        assertThatCode(() -> new Lotto(List.copyOf(givenNumbers)))
                .doesNotThrowAnyException();
    }
}