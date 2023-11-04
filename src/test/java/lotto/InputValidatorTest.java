package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 보너스_번호가_로또_번호와_중복이면_예외() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);

        int bonusNumber = 6;

        assertThatThrownBy(() -> InputValidator.validateBonusNumberNoDuplicate(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호와 보너스 번호가 겹칩니다.");
    }

    @Test
    void 로또_번호가_1에서_45가_아니면_예외() {
        int number = 46;

        assertThatThrownBy(() -> InputValidator.validateIsLottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 숫자는 0에서 45사이의 숫자여야 합니다.");
    }

    @Test
    void 로또_번호_1에서_45_() {
        int number = 33;

        assertThatCode(() -> InputValidator.validateIsLottoNumber(number)).doesNotThrowAnyException();
    }

    @Test
    void 입력이_숫자면_아무일_없음() {
        String input = "10000";

        assertThatCode(() -> InputValidator.validateIsNumeric(input)).doesNotThrowAnyException();
    }

    @Test
    void 입력이_숫자가_아니면_예외() {
        String input = "ads";

        assertThatThrownBy(() -> InputValidator.validateIsNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자를 입력해야 합니다.");
    }

    @Test
    void 금액_천원_단위면_아무일_없음() {
        int number = 100000;

        assertThatCode(() -> InputValidator.validateDivision1000(number)).doesNotThrowAnyException();
    }

    @Test
    void 구매_금액_천원_단위_아니면_예외() {
        int number = 8400;
        assertThatThrownBy(() -> InputValidator.validateDivision1000(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.");
    }
}