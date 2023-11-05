package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 이하이면 예외가 발생한다")
    @Test
    void createLottoByLessSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되어 생성된다")
    @Test
    void createLottoSorted() {
        Lotto lotto = new Lotto(List.of(12, 11, 10, 9, 8, 7));
        assertThat(lotto.getNumbers()).containsExactly(7, 8, 9, 10, 11, 12);
    }

    @DisplayName("로또 번호가 특정 번호를 포함하는지 확인")
    @Test
    void testHasNumber() {
        Lotto lottoWithNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertTrue(lottoWithNumber.hasNumber(6));
    }

    @DisplayName("로또 번호가 특정 번호를 포함하지 않는지 확인")
    @Test
    void testDoesNotHaveNumber() {
        Lotto lottoWithoutNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertFalse(lottoWithoutNumber.hasNumber(33));
    }
}