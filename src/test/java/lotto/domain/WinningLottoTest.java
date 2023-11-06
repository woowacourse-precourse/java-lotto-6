package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ExceptionConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    String winningNumbers;

    @BeforeEach
    void init() {
        winningNumbers = "1,6,8,16,20,45";
    }

    @Test
    void 당첨번호와_보너스금액이_중복되면_예외발생() {
        String bonusNumber = "1";

        assertThatThrownBy(() -> WinningLotto.of(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionConstant.LOTTO_NUMBER_DUPliCATE.getMessage());
    }

    @Test
    void 보너스금액이_1미만일_경우_예외발생() {
        String winningNumberss = "10,20,30,40,22,41";
        String bonusNumber = "0";

        assertThatThrownBy(() -> WinningLotto.of(winningNumberss, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionConstant.LOTTO_NUMBER_SIZE.getMessage());
    }

    @Test
    void 보너스금액이_45초과일_경우_예외발생() {
        String bonusNumber = "46";

        assertThatThrownBy(() -> WinningLotto.of(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionConstant.LOTTO_NUMBER_SIZE.getMessage());
    }
}
