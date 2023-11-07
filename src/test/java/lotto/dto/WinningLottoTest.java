package lotto.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.ErrorCode;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @Test
    @DisplayName("보너스 번호가 이미 당첨 번호 안에 존재하는 값이라면 예외를 발생한다.")
    public void should_throwException_when_duplicated() {
        Lotto winning = getWinning("1,2,3,4,5,6");
        LottoNumber bonus = getBonus("6");
        assertThatThrownBy(() -> WinningLotto.of(winning, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.DUPLICATED_LOTTO_NUMBER.getMessage());
    }

    private Lotto getWinning(String input) {
        return new Lotto(input);
    }

    private LottoNumber getBonus(String input) {
        return LottoNumber.from(input);
    }
}