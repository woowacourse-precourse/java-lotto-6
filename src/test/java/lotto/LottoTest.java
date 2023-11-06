package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또가 오름차순이 아니면 예외가 발생한다.")
    @Test
    void createLottoByDescendingOrder() {
        assertThatThrownBy(() -> new Lotto(List.of(6, 5, 4, 3, 2, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동일한 로또라면 결과는 6이다")
    @Test
    void countMatchingNumberAllSame() {
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(1,2,3,4,5,6));
        assertEquals(6,lotto1.countMatchingNumber(lotto2));
    }

    @DisplayName("한 자리도 겹치지 않으면 0이다")
    @Test
    void countMatchingNumberAllDifferent() {
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(7,8,9,10,11,12));
        assertEquals(0,lotto1.countMatchingNumber(lotto2));
    }
}