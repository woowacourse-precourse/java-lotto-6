package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinningLotto")
class WinningLottoTest {

    @Test
    @DisplayName("BonusNumber가 Lotto에 중복되면 예외를 던지는가")
    void bonus_number_include_lotto() {
        //given
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final WinningLotto winningLotto = new WinningLotto(lotto);
        final Integer duplicatedNumber = 1;

        //when & then
        assertThatThrownBy(() -> winningLotto.updateBonusNumber(duplicatedNumber)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("BonusNumber가 Lotto에 중복되지 않으면 예외를 던지지 않는가")
    void is_divided_by_one_thousand() {
        //given
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final WinningLotto winningLotto = new WinningLotto(lotto);
        final Integer nonDuplicatedNumber = 7;

        //when & then
        assertThatNoException().isThrownBy(() -> winningLotto.updateBonusNumber(nonDuplicatedNumber));
    }
}
