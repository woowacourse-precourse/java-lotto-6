package lotto.v3.model;

import lotto.v3.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    @Test
    void shouldThrowExceptionIfNumbersAreNotBetween1And45() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(Arrays.asList(0, 2, 3, 4, 5, 6)))
                .withMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("유효한 로또 번호 리스트를 제공하면 로또 객체가 생성된다.")
    @Test
    void shouldCreateLottoWhenValidNumbersAreProvided() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 번호는 생성 시 정렬되어야 한다.")
    @Test
    void shouldSortNumbersOnCreation() {
        Lotto lotto = new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1));
        assertThat(lotto.getNumbers()).containsExactly(6, 5, 4, 3, 2, 1);
    }

}