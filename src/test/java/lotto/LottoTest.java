package lotto;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    @DisplayName("로또 번호의 개수가 6보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 생성할 때 null을 넘기면 예외가 발생한다.")
    @Test
    void createLottoByNull() {
        assertThatThrownBy(() -> new Lotto(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤 로또 생성 테스트 - 중복되지 않는 숫자 6개가 생성되어야 한다.")
    @Test
    void createLottoByRandom() {
        Lotto lotto = Lotto.generate();
        List<Integer> numbers = lotto.getNumbers();
        Assertions.assertThat(numbers.size()).isEqualTo(6);
        // 정렬 후 앞 뒤로 같은 숫자가 있으면 중복으로 본다.
        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            Assertions.assertThat(numbers.get(i - 1)).isNotEqualTo(numbers.get(i));
        }
    }
}