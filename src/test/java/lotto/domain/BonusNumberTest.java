package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ExceptionConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {

    String winningNumbers;

    @BeforeEach
    void init() {
        winningNumbers = "1,6,8,16,20,45";
    }

//    @Test
//    void 당첨번호와_보너스금액이_중복되면_예외발생() {
//        String bonusNumber = "1";
//
//        assertThatThrownBy(() -> WinningLotto.of(winningNumbers, bonusNumber))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(ExceptionConstant.LOTTO_NUMBER_DUPliCATE.getMessage());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"0", "-1", "-99"})
//    void 보너스금액이_1미만일_경우_예외발생(String bonusNumber) {
//        assertThatThrownBy(() -> WinningLotto.of(winningNumbers, bonusNumber))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(ExceptionConstant.LOTTO_NUMBER_SIZE.getMessage());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"46", "99", "100"})
//    void 보너스금액이_45초과일_경우_예외발생(String bonusNumber) {
//        assertThatThrownBy(() -> WinningLotto.of(winningNumbers, bonusNumber))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(ExceptionConstant.LOTTO_NUMBER_SIZE.getMessage());
//    }
}
