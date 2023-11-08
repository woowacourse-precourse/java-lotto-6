package lotto.domain;

import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

@DisplayName("당첨 로또 객체에 대해")
class WinningLottoTest {

    private final Lotto lotto = mock(Lotto.class);
    private final BonusNumber bonusNumber = mock(BonusNumber.class);

    @Test
    @DisplayName("당첨 번호를 저장한다.")
    void Given_CreateWinningLotto_When_getLotto_Then_ContainsExactly() {
        //given
        WinningLotto winningLotto = WinningLotto.of(lotto, bonusNumber);
        given(lotto.getNumbers()).willReturn(List.of(1, 2, 3, 4, 5, 6));

        //when
        List<Integer> lotto = winningLotto.getLotto();

        //then
        assertThat(lotto).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("보너스 번호를 저장한다.")
    void Given_CreateWinningLotto_When_GetBonusNumber_Then_Equal() {
        //given
        WinningLotto winningLotto = WinningLotto.of(lotto, bonusNumber);

        //when
        BonusNumber actualBonusNumber = winningLotto.getBonusNumber();

        //then
        assertThat(actualBonusNumber).isEqualTo(bonusNumber);
    }
}
