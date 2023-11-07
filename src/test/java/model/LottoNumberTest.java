package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void 동등성_비교_검사() {
        // given
        LottoNumber number1 = LottoNumber.from(1);
        LottoNumber number2 = LottoNumber.from(1);

        // then
        assertEquals(number1, number2);
    }
}
