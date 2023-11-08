package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 ~ 45 범위의 수를 넘으면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("일치 번호 개수 테스트")
    @Test
    void getMatchCountTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = WinningNumber.from("1,2,3,4,5,6");

        // when
        int matchCount = lotto.getMatchCount(winningNumber);
        int expectedMatchCount = 6;

        // then
        assertThat(matchCount).isEqualTo(expectedMatchCount);
    }

    @DisplayName("보너스 일치 여부 테스트")
    @Test
    void isMatchBonusTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = WinningNumber.from("10,11,12,13,14,15");
        BonusNumber bonusNumber = BonusNumber.ofNotDuplicatedWithWinningNumber("3", winningNumber);

        // when
        boolean matchBonus = lotto.isMatchBonus(bonusNumber);

        // then
        assertThat(matchBonus).isTrue();
    }
}