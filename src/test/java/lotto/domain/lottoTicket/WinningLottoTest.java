package lotto.domain.lottoTicket;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("winningNumbers 와 bonusNumber 로 객체를 생성할 수 있다.")
    @Test
    void generateClass() {
        //given
        Lotto winningNumbers = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.from(7);

        //when
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);

        //then
        assertThat(winningLotto).isNotNull();
    }

    @DisplayName("winningNumbers 에 bonusNumber 가 포함되어 있으면 예외를 발생한다.")
    @Test
    void throwExceptionContainedBonusNumber() {
        //given
        Lotto winningNumbers = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.from(1);

        //when
        //then
        assertThatThrownBy(() -> WinningLotto.of(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningLotto.CONTAINED_EXCEPTION);
    }

    @DisplayName("winningLotto 를 만들면 lotto 와 비교해 결과를 가져올 수 있다.")
    @Test
    void matchWinningLottoAndLotto() {
        //given
        Lotto winningNumbers = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.from(1);

        //when
        //then
        assertThatThrownBy(() -> WinningLotto.of(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningLotto.CONTAINED_EXCEPTION);
    }
}