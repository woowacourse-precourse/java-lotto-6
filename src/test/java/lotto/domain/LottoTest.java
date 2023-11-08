package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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

    @DisplayName("로또 번호가 1 ~ 45 범위가 아니라면 예외가 발생한다.")
    @Test
    void createLottoOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 ~ 45 사이의 숫자만 가능합니다.");
    }

    @DisplayName("숫자가 올바른 로또라면 true를 반환한다")
    @Test
    void checkMatchedNumber() {
        // given
        int validNumber = 6;
        boolean expected = true;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean actual = lotto.hasMatchedNumber(validNumber);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("숫자가 올바르지 않은 로또라면 false를 반환한다")
    @Test
    void checkUnmatchedNumber() {
        // given
        int invalidNumber = 7;
        boolean expected = false;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean actual = lotto.hasMatchedNumber(invalidNumber);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}
