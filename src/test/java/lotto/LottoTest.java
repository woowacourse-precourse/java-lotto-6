package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.Lotto;
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
    @DisplayName("주어진 로또 번호와 일치하는 번호의 개수를 구합니다.")
    @Test
    void 일치번호_개수_계산() {
        // GIVEN
        List<Integer> thisNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto thisLotto = new Lotto(thisNumbers);
        List<Integer> thatNumbers = List.of(4, 5, 6, 7, 8, 9);
        Lotto thatLotto = new Lotto(thatNumbers);
        // WHEN
        int matchNumberCount = thisLotto.getMatchNumberCount(thatLotto);
        // THEN
        assertEquals(3, matchNumberCount);
    }
}