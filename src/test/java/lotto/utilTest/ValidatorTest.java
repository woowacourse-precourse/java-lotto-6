package lotto.utilTest;

import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.utilTest.Validator.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @Test
    void shouldThrowIllegalException_whenMoneyInputHasRemains() {
        Integer testMoney = 1500;

        assertThatThrownBy(() -> validateIntegerMoney(testMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 금액은 1000원으로 나누어 떨어져야 합니다");
    }

    @Test
    void shouldThrowIllegalException_whenMoneyInputIsLowerThan0() {
        Integer testMoney = -50;

        assertThatThrownBy(() -> validateIntegerMoney(testMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 0 이상의 정수가 되어야 합니다");
    }

    @Test
    void shouldThrowIllegalException_whenLottoNumberHasDuplicatedNumbers() {
        List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> validateLottoNumbers(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 중복되면 안됩니다");
    }
    @Test
    void shouldThrowIllegalException_whenLottoNumberIsBiggerThan_45() {
        List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> validateLottoNumbers(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 45이하 이어야 합니다");
    }

    @Test
    void shouldThrowIllegalException_whenLottoNumberIsLowerThan_1() {
        List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 0);

        assertThatThrownBy(() -> validateLottoNumbers(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1이상 이어야 합니다");
    }

    @Test
    void shouldThrowIllegalException_whenLottoNumberSizeIsNot_6() {
        List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> validateLottoNumbers(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개 이어야 합니다");
    }
    @Test
    void shouldThrowIllegalException_whenBonusNumberisBlank() {
        String bonusNumber = " ";
        assertThatThrownBy(() -> validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 공백이 될 수 없습니다");
    }
    @Test
    void shouldThrowIllegalException_whenLottoNumberHasBonusNumber() {
        Integer bonusNumber = 10;
        List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 10);
        assertThatThrownBy(() -> checkDuplcate(lottoNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호와 입력한 로또 번호가 중복되면 안됩니다");
    }
}
