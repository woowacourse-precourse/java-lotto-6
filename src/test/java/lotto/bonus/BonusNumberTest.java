package lotto.bonus;

import lotto.lotto.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto("1,2,3,4,5,6");
    }

    @DisplayName("보너스 번호를 정수로 입력하지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"12.1", "abc"})
    @ParameterizedTest
    void createBonusNumberByNotInteger(String number) {
        Assertions.assertThatThrownBy(() -> makeBonusNumber(number, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1 ~ 45인 숫자가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"-1", "0", "46"})
    @ParameterizedTest
    void createBonusNumberByWrongRangeNumber(String number) {
        Assertions.assertThatThrownBy(() -> makeBonusNumber(number, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 있으면 예외가 발생한다.")
    @Test
    void creatBonusNumberByDuplicateWinningNumber() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
        Assertions.assertThatThrownBy(() -> makeBonusNumber("1", winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void makeBonusNumber(String number, WinningLotto winningLotto) {
        BonusNumber.of(number, winningLotto);
    }
}
