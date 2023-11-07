package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @Test
    @DisplayName("당첨 번호와 중복되지 않는 보너스 번호를 생성한다.")
    void 보너스_번호_생성_성공_테스트() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumbers);
        Assertions.assertThat(bonusNumber.get()).isEqualTo(7);
    }

    @Test
    @DisplayName("당첨 번호와 중복되는 보너스 번호를 생성한다.")
    void 보너스_번호_생성_실패_테스트() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(1, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스_번호_범위_실패_테스트(int number) {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(number, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}