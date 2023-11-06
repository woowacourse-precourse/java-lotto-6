package lotto.domain;

import static lotto.domain.enums.ErrorMessage.DUPLICATE_NUMBER_ERROR_MESSAGE;
import static lotto.domain.enums.ErrorMessage.NUMBER_OUT_OF_RANGE_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호에 보너스 번호가 포함되어 있으면 예외가 발생한다.")
    void createWinningLottoByContainingBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NUMBER_ERROR_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    void createWinningLottoByOutOfRangeBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_OUT_OF_RANGE_ERROR_MESSAGE.getMessage());
    }


}