package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("로또 번호에 유효하지 않은 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByInvalidNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, -1, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getNumbers() {
        // given
        Lotto case1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        List<Integer> result1 = case1.getNumbers();

        // then
        assertThat(result1).as("case1").isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void contains() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int case1 = 1;
        int case2 = 45;

        // when
        boolean result1 = lotto.contains(case1);
        boolean result2 = lotto.contains(case2);

        // then
        assertThat(result1).as("case1").isEqualTo(true);
        assertThat(result2).as("case2").isEqualTo(false);
    }

    @Test
    void testToString() {
        // given
        Lotto case1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        String result = case1.toString();

        // then
        assertThat(result).as("case1").isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}