package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void isBonusNumberDuplicate() {
        // given
        Lotto lotto = FixtureFactory.getLotto();
        int bonusNumber = 1;

        // when & then
        assertThatThrownBy(() -> lotto.isBonusNumberDuplicate(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발행된 로또 번호가 보너스 번호를 포함하는지 확인한다.")
    @Test
    void containsBonusNumber() {
        // given
        Lotto lotto = FixtureFactory.getLotto();
        int bonusNumber = 1;

        // when
        boolean containsBonusNumber = lotto.containsBonusNumber(bonusNumber);

        // then
        assertThat(containsBonusNumber).isTrue();
    }

    @DisplayName("발행된 로또 번호와 당첨 번호가 모두 일치한다.")
    @Test
    void getMatchingCountOfWinningNumbers() {
        // given
        Lotto lotto = FixtureFactory.getLotto();
        Lotto winningNumbers = FixtureFactory.getLotto();

        // when
        int matchingCountOfWinningNumbers = lotto.getMatchingCountOfWinningNumbers(winningNumbers);

        // then
        assertThat(matchingCountOfWinningNumbers).isEqualTo(6);
    }
}