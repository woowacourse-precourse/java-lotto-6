package lotto;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.errorchek.ErrorCheck;

public class ErrorCheckTest {

    @DisplayName("입력금액의 범위 오류 테스트")
    @Test
    void MoneyInput_범위_오류_테스트() throws Exception {
        String error_Range1 = "0";
        String error_Range2 = "12501252501000";
        try {
            ErrorCheck.MoneyInput(error_Range1);
        } catch (IllegalArgumentException error) {
            Assertions.assertEquals("[ERROR] : 입력하신 구매액의 범위가 알맞지 않습니다.", error.getMessage());
        }
        try {
            ErrorCheck.MoneyInput(error_Range2);
        } catch (IllegalArgumentException error) {
            Assertions.assertEquals("[ERROR] : 입력하신 구매액의 범위가 알맞지 않습니다.", error.getMessage());
        }
    }

    @DisplayName("입력금액이 문자 일 경우 오류 테스트")
    @Test
    void MoneyInput_문자입력_테스트() throws Exception {
        String error_Number = "124sdf";
        String error_Number2 = "1_234_124";
        String error_Number3 = "1234124L";
        try {
            ErrorCheck.MoneyInput(error_Number);
        } catch (IllegalArgumentException error) {
            Assertions.assertEquals("[ERROR] : 입력하신 구매액이 올바르지 않습니다.(숫자로 읽히지 않음)", error.getMessage());
        }
        try {
            ErrorCheck.MoneyInput(error_Number2);
        } catch (IllegalArgumentException error) {
            Assertions.assertEquals("[ERROR] : 입력하신 구매액이 올바르지 않습니다.(숫자로 읽히지 않음)", error.getMessage());
        }
        try {
            ErrorCheck.MoneyInput(error_Number3);
        } catch (IllegalArgumentException error) {
            Assertions.assertEquals("[ERROR] : 입력하신 구매액이 올바르지 않습니다.(숫자로 읽히지 않음)", error.getMessage());
        }
    }

    @DisplayName("입력금액의 단위 오류 테스트")
    @Test
    void MoneyInput_단위_오류_테스트() throws Exception {
        String error_UnitConfirmation = "12424";
        try {
            ErrorCheck.MoneyInput(error_UnitConfirmation);
        } catch (IllegalArgumentException error) {
            Assertions.assertEquals("[ERROR] : 입력하신 구매액이 올바르지 않습니다.(구매액은 1000원 단위로만 판매함)", error.getMessage());
        }
    }
}
