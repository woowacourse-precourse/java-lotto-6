package lotto;

import static org.junit.jupiter.api.Assertions.*;

import lotto.model.InputLottoNumber;
import org.junit.jupiter.api.Test;

class InputLottoNumberTest {

    @Test
    void 당첨번호를_아무것도_입력하지_않았습니다() {
        String inputNumber = "";
        assertThrows(IllegalArgumentException.class,
            () -> new InputLottoNumber(inputNumber));
    }

    @Test
    void 당첨번호는_6자리_숫자여야_합니다() {
        String inputNumber = "1,2,3,4,5,6,7,8,9,10";
        assertThrows(IllegalArgumentException.class,
            () -> new InputLottoNumber(inputNumber)
        );
    }

    @Test
    void 당첨번호는_숫자로만_구성되어야_합니다() {
        String inputNumber = "1,2,3,ㄱ,ㄴ,ㄷ";
        assertThrows(IllegalArgumentException.class,
            () -> new InputLottoNumber(inputNumber));
    }

    @Test
    void 당첨번호는_1부터_45까지만_구성되어야_합니다() {
        String inputNumber = "1,2,3,46,47,48";
        assertThrows(IllegalArgumentException.class,
            () -> new InputLottoNumber(inputNumber)
        );
    }

    @Test
    void 당첨번호는_유니크한_숫자로만_구성되어야_합니다() {
        String inputNumber = "1,2,3,1,2,3";
        assertThrows(IllegalArgumentException.class,
            () -> new InputLottoNumber(inputNumber));
    }
}