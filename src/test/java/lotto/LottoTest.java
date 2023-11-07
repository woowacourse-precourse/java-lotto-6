package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import lotto.system.shop.domain.ticket.lotto.Lotto;
import lotto.system.shop.exception.lotto.LottoSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외가 발생 한다.")
    void createLottoByNotSixSize() {
        assertThrows(LottoSizeException.class, () -> {
            new Lotto(List.of(1, 2, 3, 4, 5));
        });
    }

    @Test
    @DisplayName("로또 번호는 오름차 순으로 정렬 되어야 한다.")
    void createLottoByNotAscendingOrder() {
        // given
        List<Integer> numbers = List.of(3, 2, 1, 6, 5, 4);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Integer::compareTo);
        for (int i = 0; i < 6; i++) {
            assertThat(lottoNumbers.get(i)).isEqualTo(sortedNumbers.get(i));
        }
    }
}