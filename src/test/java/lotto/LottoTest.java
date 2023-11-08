package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static lotto.ErrorMessage.LOTTO_OUT_OF_RANGE_MESSAGE;
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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_OUT_OF_RANGE_MESSAGE);

        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_OUT_OF_RANGE_MESSAGE);
    }

    @Test
    void draw() {
        Lotto winningNumber = new Lotto(List.of(7, 18, 19, 26, 33, 45));
        int bonus = 37;

        Lotto first = new Lotto(List.of(7, 18, 19, 26, 33, 45));
        Lotto second = new Lotto(List.of(7, 18, 19, 26, 33, 37));
        Lotto third = new Lotto(List.of(7, 18, 19, 26, 33, 44));
        Lotto fourth = new Lotto(List.of(7, 18, 19, 26, 27, 28));
        Lotto fifth = new Lotto(List.of(7, 18, 19, 27, 28, 29));
        Lotto lose = new Lotto(List.of(7, 18, 40, 41, 42, 43));

        assertThat(first.draw(winningNumber, bonus)).isEqualTo(Optional.of(Grade.FIRST));
        assertThat(second.draw(winningNumber, bonus)).isEqualTo(Optional.of(Grade.SECOND));
        assertThat(third.draw(winningNumber, bonus)).isEqualTo(Optional.of(Grade.THIRD));
        assertThat(fourth.draw(winningNumber, bonus)).isEqualTo(Optional.of(Grade.FOURTH));
        assertThat(fifth.draw(winningNumber, bonus)).isEqualTo(Optional.of(Grade.FIFTH));
        assertThat(lose.draw(winningNumber, bonus)).isEqualTo(Optional.empty());
    }
}