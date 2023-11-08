package lotto;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


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

    @DisplayName("범위를 넘어가는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 50, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지정된 범위 내의 6자리 수를 입력했을 경우 정상적으로 로또를 생성한다.")
    @Test
    void createLottoNumber() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers().size()).isEqualTo(numbers.size());
    }
}
