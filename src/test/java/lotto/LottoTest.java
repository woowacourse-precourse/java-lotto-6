package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


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

    @DisplayName("로또 번호가 1 부터 45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 45, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호와 당첨 번호를 비교하여 맞춘 숫자 개수가 정확히 계산되는지 확인한다.")
    @Test
    void calculateMatchingNumbers() {
        Lotto winningLotto = new Lotto(List.of(10, 20, 30, 40, 41, 42));
        Lotto userLotto = new Lotto(List.of(10, 20, 30, 40, 41, 45));
        GameResult gameResult = new GameResult(List.of(userLotto), winningLotto, 70);

        int matchingNumbers = gameResult.countMatchingNumbers(userLotto, winningLotto);

        assertThat(matchingNumbers).isEqualTo(5);
    }
}
