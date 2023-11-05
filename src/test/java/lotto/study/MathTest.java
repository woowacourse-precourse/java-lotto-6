package lotto.study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MathTest {

    @DisplayName("floorMod를 이용해 각 long/int 타입을 가지는 값의, 나머지를 계산한다.")
    @Test
    void floorModByLongAndInt() {
        //given
        long dividend = 1001;
        int divisor = 100;

        //when
        int remainder = Math.floorMod(dividend, divisor);

        //then
        assertThat(remainder).isEqualTo(1);
    }

    @DisplayName("floorMod를 이용해 피제수가 0인 값의 나머지를 계산한다.")
    @Test
    void floorModByZero() {
        //given
        long dividend = 0;
        int divisor = 10;

        //when
        int remainder = Math.floorMod(dividend, divisor);

        //then
        assertThat(remainder).isEqualTo(0);
    }

    @DisplayName("floorDiv를 이용해 각 long/int 타입을 가지는 값의, 몫을 계산한다.")
    @Test
    void floorDivByLongAndInt() {
        //given
        long dividend = 1001;
        int divisor = 100;

        //when
        long quotient = Math.floorDiv(dividend, divisor);

        //then
        assertThat(quotient).isEqualTo(10);
    }

    @DisplayName("floorDiv를 이용해 피제수가 0인 값의 몫을 계산한다.")
    @Test
    void floorDivByZero() {
        //given
        long p1 = 0;
        int p2 = 100;

        //when
        long quotient = Math.floorDiv(p1, p2);

        //then
        assertThat(quotient).isEqualTo(0);
    }

}
