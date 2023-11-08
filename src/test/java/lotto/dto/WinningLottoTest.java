package lotto.dto;

import static lotto.enums.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.fixture.LottoFixture.lottoFixture;
import static lotto.fixture.LottoFixture.lottoNumberFixture;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @Test
    void 당첨_로또_번호와_보너스_번호가_중복될_경우_예외가_발생한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = lottoFixture(numbers);
        int bonusNumber = 6;
        LottoNumber bonus = lottoNumberFixture(bonusNumber);

        // when & then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonus))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_BONUS_NUMBER.getMassage());
    }

}