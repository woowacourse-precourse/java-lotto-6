package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 번호 테스트")
class WinningLottoTest {
    private static final String INVALID_DISTINCT_ERROR_MESSAGE = "[ERROR] 보너스볼은 당첨 번호와 중복될 수 없습니다.";

    @DisplayName("당첨 번호의 로또번호와 보너스볼은 중복 되지 않는다.")
    @Test
    public void createWinningLotto_ValidInput_ReturnsWinningLotto() {
        String inputWinningNumber = "1,2,3,4,5,6";
        String inputBonusBall = "7";

        assertThatCode(
                () -> WinningLotto.createWinningLotto(inputWinningNumber, inputBonusBall)).doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호의 로또번호과 보너스볼이 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    public void createWinningLotto_BonusBallInWinningNumbers_ThrowsException() {
        String inputWinningNumber = "1,2,3,4,5,6";
        String inputBonusBall = "6";

        assertThatThrownBy(() -> WinningLotto.createWinningLotto(inputWinningNumber, inputBonusBall))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_DISTINCT_ERROR_MESSAGE);
    }
}