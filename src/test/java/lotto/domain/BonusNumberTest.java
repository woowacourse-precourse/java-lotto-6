package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ExceptionConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    Lotto lotto;

    @BeforeEach
    void init() {
        lotto = new Lotto(List.of(1,2,3,4,5,6));
    }

    @Test
    void 당첨번호와_보너스금액이_중복되면_예외발생() {
        String bonusNumber = "1";

        assertThatThrownBy(() -> BonusNumber.of(bonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionConstant.LOTTO_NUMBER_DUPliCATE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-99"})
    void 보너스금액이_1미만일_경우_예외발생(String bonusNumber) {
        assertThatThrownBy(() -> BonusNumber.of(bonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionConstant.LOTTO_NUMBER_SIZE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"46", "99", "100"})
    void 보너스금액이_45초과일_경우_예외발생(String bonusNumber) {
        assertThatThrownBy(() -> BonusNumber.of(bonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionConstant.LOTTO_NUMBER_SIZE.getMessage());
    }
}
