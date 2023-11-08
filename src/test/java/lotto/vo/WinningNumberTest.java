package lotto.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    @DisplayName("개수가 부족한 경우")
    @Test
    void testTooSmallNumberException(){
        assertThatThrownBy(() -> new WinningNumber("0,0,0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("개수가 많은 경우")
    @Test
    void testTooMuchNumbersException(){
        assertThatThrownBy(() -> new WinningNumber("0,0,0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("값이 초과된 경우")
    @Test
    void testTooMuchValueException(){
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,87,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("값이 너무 작은 경우")
    @Test
    void testTooSmallValueException(){
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,0,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자가 포함된 경우")
    @Test
    void testNotNumberException(){
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,k,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백이 포함된 경우")
    @Test
    void testNotNullException(){
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 양식이 잘못된 경우")
    @Test
    void testNotFormException(){
        assertThatThrownBy(() -> new WinningNumber("1.2.3.4.5.6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("값이 중복된 경우")
    @Test
    void testDupException(){
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}