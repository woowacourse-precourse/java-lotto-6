package lotto;

import lotto.domain.WinningNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @DisplayName("구입 금액 저장기능이 잘 작동하는가")
    @Test
    void test1(){
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        Assertions.assertEquals(winningNumber.getWinningNumber(), List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨번호가 \",\"로 구분될 수 없을 때 예외 발생")
    @Test
    void test2(){
        WinningNumber winningNumber = new WinningNumber();
        assertThatThrownBy(() -> winningNumber.validateSplitCheck("1.sf-2r"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 숫자가 아닐 때 예외 발생")
    @Test
    void test3(){
        WinningNumber winningNumber = new WinningNumber();
        String[] numbers = {"1", "s", "abc", "a", "asf"};

        assertThatThrownBy(() -> winningNumber.validateIsNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("당청번호의 숫자가 1~45사이의 숫자가 아닐 때 예외 발생")
    @Test
    void test4(){
        WinningNumber winningNumber = new WinningNumber();
        String[] numbers = {"1", "0", "-50", "24", "31"};
        assertThatThrownBy(() -> winningNumber.validateRange(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("당첨번호의 개수가 6개가 아닐때 예외 발생")
    @Test
    void test5(){
        WinningNumber winningNumber = new WinningNumber();
        String[] numbers = {"1", "0", "-50", "24"};
        assertThatThrownBy(() -> winningNumber.validateCount(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("당첨번호에 중복이 있는 경우 예외 발생")
    @Test
    void test6(){
        WinningNumber winningNumber = new WinningNumber();
        String[] numbers = {"1", "5", "-30", "24", "24"};
        assertThatThrownBy(() -> winningNumber.validateCount(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }



}
