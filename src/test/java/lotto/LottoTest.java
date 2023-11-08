package lotto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoInRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 받은 인자를 비교해서 중복된 값이 있는지 검사.")
    @Test
    void checkIsIncluded() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; ++i) {
            numbers.add(i);
        }
        Lotto lotto = new Lotto(numbers);
        boolean result = lotto.isIncluded(1);
        assertThat(result).isEqualTo(true);
        result = lotto.isIncluded(7);
        assertThat(result).isEqualTo(false);
    }

    // 아래에 추가 테스트 작성 가능
}