package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45 범위 외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다른 로또와의 일치 개수")
    @Test
    void testCountMatches() {
        Lotto lotto1 = new Lotto(List.of(5,10,15,20,25,30));
        Lotto lotto2 = new Lotto(List.of(20,25,30,35,40,45));
        int result = lotto1.countMatches(lotto2);
        int answer = 3;

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("보너스 번호와의 일치 여부")
    @Test
    void testMatchWithBonus() {
        Lotto lotto = new Lotto(List.of(7,15,22,29,37,45));
        int bonusNumber = 29;
        boolean result = lotto.matchWithBonus(bonusNumber);
        boolean answer = true;

        assertThat(result).isEqualTo(answer);
    }
}