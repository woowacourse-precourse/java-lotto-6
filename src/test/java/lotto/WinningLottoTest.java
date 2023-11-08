package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import lotto.model.Exception;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {
    @DisplayName("보너스 번호에 숫자가 아닌 값이 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"숫자아님", "notNumber", "1섞어2MIX3"})
    void createWinningLottoByNonNumericValueBonusNumber(String bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Exception.NON_NUMERIC_BONUS_NUMBERS_ERROR.getMessage());
    }

    @DisplayName("보너스 번호에 범위(1 ~ 45) 밖의 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "21474836478"})
    void createWinningLottoByOverRangeBonusNumber(String bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Exception.OUT_OF_RANGE_BONUS_MONEY_ERROR.getMessage());
    }

    @DisplayName("보너스 번호가 로또번호에 포함되어져있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByLottoNumbersContainBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Exception.LOTTO_NUMBERS_CONTAIN_BONUS_NUMBER_ERROR.getMessage());
    }

    @DisplayName("보너스 번호가 null인 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void createWinningLottoByNullOrEmptyBonusNumber(String bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Exception.OUT_OF_RANGE_BONUS_MONEY_ERROR.getMessage());
    }

    @DisplayName("보너스번호가 정상적으로 들어온 경우.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "45"})
    void createWinningLottoByNormal(String bonusNumber) throws NoSuchFieldException, IllegalAccessException {
        Lotto winningLotto = new WinningLotto("2,3,4,5,6,7", bonusNumber);

        Field privateField = WinningLotto.class.getDeclaredField("bonusNumber");
        privateField.setAccessible(true);
        Integer lottoPrivateBonusNumbers = (Integer) privateField.get(winningLotto);

        assertEquals(lottoPrivateBonusNumbers, Integer.valueOf(bonusNumber));
    }

    @DisplayName("로또 번호를 입력으로 받아 당첨된 등수 반환하는 기능 테스트.")
    @Test
    void checkLottoWinningRank() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        Lotto rank1 = new Lotto("1,2,3,4,5,6");
        Lotto rank2 = new Lotto("1,2,3,4,5,7");
        Lotto rank3 = new Lotto("1,2,3,4,5,8");
        Lotto rank4 = new Lotto("1,2,3,4,7,8");
        Lotto rank5 = new Lotto("1,2,3,9,12,13");
        Lotto rank0 = new Lotto("1,2,15,13,12,17");

        assertEquals(winningLotto.checkLottoRanking(rank1), 1);
        assertEquals(winningLotto.checkLottoRanking(rank2), 2);
        assertEquals(winningLotto.checkLottoRanking(rank3), 3);
        assertEquals(winningLotto.checkLottoRanking(rank4), 4);
        assertEquals(winningLotto.checkLottoRanking(rank5), 5);
        assertEquals(winningLotto.checkLottoRanking(rank0), 0);
    }
}
