package lotto;

import lotto.domain.Lotto;
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

    @DisplayName("입력한 값대로 정상적으로 출력되는지 확인한다.")
    @Test
    void createLottoCompareInputWithOutput() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(input);
        List<Integer> output = lotto.getLotto();
        assertThat(output).isEqualTo(input);
    }

    @DisplayName("리스트에서 일치하는 값의 갯수가 정상적으로 나오는지 테스트")
    @Test
    void testCountMatches() {
        List<Integer> winningList = List.of(1, 3, 5, 8, 10, 12);
        List<Integer> numbers = List.of(1, 3, 5, 7, 9, 11);
        Lotto lotto = new Lotto(numbers);
        int matches = lotto.countMatches(winningList);
        assertThat(matches).isEqualTo(3);
    }
}