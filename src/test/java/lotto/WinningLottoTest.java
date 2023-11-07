package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {

    @DisplayName("보너스 번호에 숫자가 아닌 값이 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"숫자아님", "notNumber", "1섞어2MIX3"})
    void createWinningLottoByNonNumericValueBonusNumber(String bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 보너스 번호에 숫자가 아닌 값이 들어왔습니다.");
    }

    @DisplayName("보너스 번호에 범위(1 ~ 45) 밖의 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void createWinningLottoByOverRangeBonusNumber(String bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또번호에 포함되어져있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByLottoNumbersContainBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 null인 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullSource
    void createWinningLottoByNullOrEmptyBonusNumber(String bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 정상적으로 들어온 경우.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "45"})
    void createLottoByNormal(String bonusNumber) throws NoSuchFieldException, IllegalAccessException {
        Lotto winningLotto = new WinningLotto("2,3,4,5,6,7", bonusNumber);

        Field privateField = WinningLotto.class.getDeclaredField("bonusNumber");
        privateField.setAccessible(true);
        Integer lottoPrivateBonusNumbers = (Integer) privateField.get(winningLotto);

        assertEquals(lottoPrivateBonusNumbers, Integer.valueOf(bonusNumber));
    }
}
