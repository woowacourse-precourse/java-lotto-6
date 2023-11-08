package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.config.LottoConfig;
import lotto.exception.BonusNumberDuplicatedException;
import lotto.exception.BonusNumberOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("보너스 번호가 유효 범위를 벗어날 경우 예외 발생")
    @Test
    void shouldThrowExceptionWhenBonusNumberIsOutOfRange() {
        WinningLotto winningLotto = WinningLotto.from(List.of(1, 2, 3, 4, 5, 6));
        Integer invalidBonusNumber = LottoConfig.MAX_LOTTO_NUMBER + 1;

        assertThatThrownBy(() -> {
            winningLotto.addBonusNumber(invalidBonusNumber);
        }).isInstanceOf(BonusNumberOutOfRangeException.class);
    }

    @DisplayName("보너스 번호가 기존 로또 번호와 중복될 경우 예외 발생")
    @Test
    void shouldThrowExceptionWhenBonusNumberIsDuplicated() {
        WinningLotto winningLotto = WinningLotto.from(List.of(1, 2, 3, 4, 5, 6));
        Integer duplicatedBonusNumber = 1;

        assertThatThrownBy(() -> {
            winningLotto.addBonusNumber(duplicatedBonusNumber);
        }).isInstanceOf(BonusNumberDuplicatedException.class);
    }
}