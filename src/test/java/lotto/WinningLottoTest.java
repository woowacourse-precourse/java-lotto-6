package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {
    static Integer lottoNumberSize;
    static Integer minLottoNumber;
    static Integer maxLottoNumber;

    @BeforeAll
    public static void getConstantValue() throws NoSuchFieldException, IllegalAccessException {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Field privateLottoNumberSize = Lotto.class.getDeclaredField("LOTTO_NUMBER_SIZE");
        Field privateMinLottoNumber = Lotto.class.getDeclaredField("MIN_LOTTO_NUMBER");
        Field privateMaxLottoNumber = Lotto.class.getDeclaredField("MAX_LOTTO_NUMBER");
        privateMinLottoNumber.setAccessible(true);
        privateMaxLottoNumber.setAccessible(true);
        privateLottoNumberSize.setAccessible(true);
        lottoNumberSize = (Integer) privateLottoNumberSize.get(lotto);
        minLottoNumber = (Integer) privateMinLottoNumber.get(lotto);
        maxLottoNumber = (Integer) privateMaxLottoNumber.get(lotto);
    }

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
    void createWinningLottoByOverRangeBonusNumber(String bonusNumber) throws Exception {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 지정된 범위안의 숫자만 가질 수 있습니다. 범위 "
                        + minLottoNumber + "~" + maxLottoNumber);
    }

    @DisplayName("보너스 번호가 로또번호에 포함되어져있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByLottoNumbersContainBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 로또 번호와 겹치면 안됩니다.");
    }

    @DisplayName("보너스 번호가 null인 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullSource
    void createWinningLottoByNullOrEmptyBonusNumber(String bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호를 입력해주세요.");
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
