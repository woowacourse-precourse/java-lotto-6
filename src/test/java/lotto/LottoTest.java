package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("로또 번호가 정렬되어 있는지 확인한다.")
    @Test
    void isSortedLotto() {
        List<Integer> sortedNumbers = new Lotto(List.of(6, 3, 4, 5, 1, 2)).getSortedNumbers();
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), sortedNumbers);
    }

    @DisplayName("로또가 생성되는지 확인")
    @Test
    void generateLotto() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        List<Lotto> allLotto = lottoGenerator.generateLotto(3); // 3개의 로또 생성

        assertThat(allLotto).hasSize(3);
        for (Lotto lotto : allLotto) {
            assertThat(lotto.getSortedNumbers()).hasSize(6);
        }
    }
}