package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 정상 입력 시 예외가 발생하지 않는다.")
    @Test
    void createValidLotto() {
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하고 일치하는 개수를 반환한다.")
    @Test
    void calculateMatchingCount() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int matchingCount = lotto.calculateMatchingCount(List.of(1, 2, 3, 7, 8, 9));
        assertEquals(3, matchingCount);
    }

    @DisplayName("로또 번호와 보너스 번호를 비교하고 일치하는 개수를 반환한다.")
    @Test
    void calculateBonusCount() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusCount = lotto.calculateBonusCount(7);
        assertEquals(0, bonusCount);

        bonusCount = lotto.calculateBonusCount(3);
        assertEquals(1, bonusCount);
    }
}