package lotto.io;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {

    @Test
    void 구입_금액을_입력받는다() {
        LottoInput lottoInput = new LottoInput(() -> "1000");

        assertEquals(1000, lottoInput.receiveMoney());
    }

    @Test
    void 구입_금액이_숫자가_아닌경우_예외를_반환한다() {
        LottoInput lottoInput = new LottoInput(() -> "a");

        assertThatThrownBy(lottoInput::receiveMoney)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IoException.ERROR.getMessage());
    }

    @Test
    void 당첨번호를_입력받는다() {
        LottoInput lottoInput = new LottoInput(() -> "1,2,3,4,5,6");

        assertEquals(List.of(1,2,3,4,5,6), lottoInput.receiveLottos());
    }

    @Test
    void 당첨번호에_숫자가_아닌_문자가_포함된_경우_예외를_반환한다() {
        LottoInput lottoInput = new LottoInput(() -> "1,a.2,3,4,5");

        assertThatThrownBy(lottoInput::receiveMoney)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IoException.ERROR.getMessage());
    }

    @Test
    void 쉼표를_맨앞에_붙이고_당첨번호를_입력한_경우_예외를_반환한다() {
        LottoInput lottoInput = new LottoInput(() -> ",1,2,3,4,5,6");

        assertThatThrownBy(lottoInput::receiveMoney)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IoException.ERROR.getMessage());
    }

    @Test
    void 당첨번호를_입력하고_쉼표를_맨뒤에_붙인_경우_예외를_반환한다() {
        LottoInput lottoInput = new LottoInput(() -> "1,2,3,4,5,6,");

        assertThatThrownBy(lottoInput::receiveMoney)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IoException.ERROR.getMessage());
    }

    @Test
    void 보너스_번호를_입력받는다() {
        LottoInput lottoInput = new LottoInput(() -> "1");

        assertEquals(1, lottoInput.receiveBonus());
    }

    @Test
    void 보너스_번호_입력시_숫자가_아닐경우_예외를_던진다() {
        LottoInput lottoInput = new LottoInput(() -> "a");

        assertThatThrownBy(lottoInput::receiveBonus)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IoException.ERROR.getMessage());
    }
}
