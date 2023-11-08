package lotto.verification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @DisplayName("구입 금액이 최소 1000원 이상이 아니거나, 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void verifyRangeInputMoney() {
        //given
        final long case1 = 100;
        final long case2 = 2300;
        final long case3 = 3000;

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyRangeInputMoney(case1);
        });

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyRangeInputMoney(case2);
        });

        //when & then
        assertDoesNotThrow(() -> {
            Validation.verifyRangeInputMoney(case3);
        });
    }

    @DisplayName("구입 금액에 대해 아무것도 입력 안했을 때 예외가 발생한다.")
    @Test
    void verifyEmptyInputMoney() {
        //given
        final String case1 = "";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyEmptyInputMoney(case1);
        });
    }


    @DisplayName("구입 금액 입력 값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void verifyStringToLong() {
        //given
        final String case1 = "a123";
        final String case2 = "  ";
        final String case3 = "asdfb";
        final String case4 = "1    ";
        final String case5 = "10000";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyStringToLong(case1);
        });

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyStringToLong(case2);
        });

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyStringToLong(case3);
        });

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyStringToLong(case4);
        });

        //when & then
        assertDoesNotThrow(() -> {
            Validation.verifyStringToLong(case5);
        });
    }

    @DisplayName("입력 받은 당첨 로또 문자열 값이 숫자가 아닌 값이 포함되있으면 예외가 발생한다.")
    @Test
    void verifyIntegerWinningLottoNumber() {
        //given
        final String case1 = "1,a,b";
        final String case2 = "a,b,c";
        final String case3 = "abc";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyIntegerWinningLottoNumber(case1);
        });

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyIntegerWinningLottoNumber(case2);
        });

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyIntegerWinningLottoNumber(case3);
        });
    }

    @DisplayName("로또 번호가 1 부터 45 까지의 숫자로 이루어져 있지 않을 때 예외가 발생한다.")
    @Test
    void verifyRangeWinningLottoNumber() {
        //given
        final String case1 = "0,2,3,4,5,6";
        final String case2 = "1,200,3,4,5,6";
        final String case3 = "-1,200,3,4,5,6";


        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyRangeWinningLottoNumber(case1);
        });

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyRangeWinningLottoNumber(case2);
        });

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyRangeWinningLottoNumber(case3);
        });
    }

    @DisplayName("보너스 번호에 대해 아무것도 입력하지 아니면 예외가 발생한다.")
    @Test
    void verifyEmptyBonusNumber() {
        //given
        final String case1 = "";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyEmptyBonusNumber(case1);
        });
    }

    @DisplayName("보너스 번호가 숫자가 아닌 값이면 예외가 발생한다.")
    @Test
    void verifyStringToInteger() {
        //given
        final String case1 = "a";
        final String case2 = "1a";
        final String case3 = "    ";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyStringToInteger(case1);
        });

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyStringToInteger(case2);
        });

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Validation.verifyStringToInteger(case3);
        });

    }
}