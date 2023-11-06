package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.constant.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {

    @DisplayName("보너스 볼 - 범위를 벗어났거나, 당첨 번호 중복일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-3, 46, 13})
    void makeBonusNumber(int input) {
        Lotto winningNumbers = new Lotto(List.of(4, 12, 13, 41, 1, 17));
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(winningNumbers, input);
        });
    }

    @DisplayName("5개를 맞췄을 경우 - 보너스 볼 매치 O")
    @Test
    void checkSecondPrize() {
        Lotto winningNumbers = new Lotto(List.of(4, 12, 13, 41, 1, 17));
        int bonusNumber = 3;
        WinningNumbers winningLotto = new WinningNumbers(winningNumbers, bonusNumber);
        Lotto purchaseLotto = new Lotto(List.of(4, 12, 13, 41, 1, 3));

        assertThat(winningLotto.checkPrize(purchaseLotto)).isEqualTo(Prize.SECOND);
    }

    @DisplayName("5개를 맞췄을 경우 - 보너스 볼 매치 X")
    @Test
    void checkThirdPrize() {
        Lotto winningNumbers = new Lotto(List.of(4, 12, 13, 41, 1, 17));
        int bonusNumber = 3;
        WinningNumbers winningLotto = new WinningNumbers(winningNumbers, bonusNumber);
        Lotto purchaseLotto = new Lotto(List.of(4, 12, 13, 41, 1, 9));

        assertThat(winningLotto.checkPrize(purchaseLotto)).isEqualTo(Prize.THIRD);
    }
}