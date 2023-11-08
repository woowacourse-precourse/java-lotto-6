package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개의 숫자를 쉼표로 구분해서 입력해 주세요.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
    }

    @DisplayName("로또 번호가 1보다 작거나 45보다 크면 예외가 발생한다. 1보다 작은 경우")
    @Test
    void createLottoByOutOfRangeNumberLessThan1() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1 이상 45 이하의 숫자를 입력해 주세요.");
    }

    @DisplayName("로또 번호가 1보다 작거나 45보다 크면 예외가 발생한다. 45보다 큰 경우")
    @Test
    void createLottoByOutOfRangeNumberGreaterThan45() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1 이상 45 이하의 숫자를 입력해 주세요.");
    }
}