package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String EMPTY_LOTTO_NUMBER_ERROR = "[ERROR] 로또 번호가 비었습니다.";
    private static final String INVALID_LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 %d부터 %d 사이의 수여야 합니다.";
    private static final String DUPLICATE_LOTTO_NUMBER_ERROR = "[ERROR] 로또의 각 번호는 중복될 수 없습니다.";

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

    @DisplayName("로또 번호에 빈 값이 들어갈 경우 예외가 발생한다.")
    @Test
    void createLottoByEmpty() {
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_LOTTO_NUMBER_ERROR);
    }

    @DisplayName("로또 번호에 null이 들어갈 경우 예외가 발생한다.")
    @Test
    void createLottoByNull() {
        assertThatThrownBy(() -> new Lotto(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_LOTTO_NUMBER_ERROR);
    }

    @DisplayName("로또 번호에 1부터 45 사이의 숫자가 아닌 값이 들어갈 경우 예외가 발생한다.")
    @Test
    void createLottoByInvalidRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(INVALID_LOTTO_NUMBER_RANGE_ERROR, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(INVALID_LOTTO_NUMBER_RANGE_ERROR, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
    }
}