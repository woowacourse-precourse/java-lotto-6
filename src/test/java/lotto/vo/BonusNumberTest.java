package lotto.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @Test
    void testOverNumberException(){
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        assertThatThrownBy(() -> new BonusNumber("46",winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("당첨번호와 보너스 번호는 중복될 수 없다.")
    @Test
    void testDupNumException(){
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        assertThatThrownBy(() -> new BonusNumber("4",winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("보너스 값 제대로 입력이 안 될 경우")
    @Test
    void testNullException(){
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        assertThatThrownBy(() -> new BonusNumber("",winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 값 제대로 입력이 안 될 경우")
    @Test
    void testTooMuchException(){
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        assertThatThrownBy(() -> new BonusNumber("8,9,11",winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 값 제대로 입력이 안 될 경우")
    @Test
    void testNotNumber1Exception(){
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        assertThatThrownBy(() -> new BonusNumber("w",winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 값 제대로 입력이 안 될 경우")
    @Test
    void testNotNumber2Exception(){
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        assertThatThrownBy(() -> new BonusNumber(",",winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 값 제대로 입력이 안 될 경우")
    @Test
    void testZeroException(){
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        assertThatThrownBy(() -> new BonusNumber("0",winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}