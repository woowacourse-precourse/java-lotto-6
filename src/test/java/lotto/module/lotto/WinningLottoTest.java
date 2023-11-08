package lotto.module.lotto;

import lotto.global.exception.LottoException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinningLottoTest {

    @Test
    void 유저_로또_번호에_보너스_번호_미포함_성공_테스트() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int nonIncludeBonusNumber = 7;
        WinningLotto winningLotto = WinningLotto.of(lotto, nonIncludeBonusNumber);

        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean isContains = winningLotto.isMatchesBonusNumber(userLotto);

        // then
        Assertions.assertThat(isContains)
                .isFalse();
    }

    @Test
    void 유저_로또_번호에_보너스_번호_포함_성공_테스트() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int nonIncludeBonusNumber = 7;
        WinningLotto winningLotto = WinningLotto.of(lotto, nonIncludeBonusNumber);

        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        // when
        boolean isContains = winningLotto.isMatchesBonusNumber(userLotto);

        // then
        Assertions.assertThat(isContains)
                .isTrue();
    }


    @Test
    void 당첨_번호와_보너스_번호_중복_익셉션_발생_성공_테스트() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int nonIncludeBonusNumber = 6;

        String errorMessage = LottoException.LOTTO_BONUS_NUMBER_DUPLICATE_VALIDATION.getDefaultMessage();

        // when
        // then
        Assertions.assertThatThrownBy(() -> WinningLotto.of(lotto, nonIncludeBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }


}