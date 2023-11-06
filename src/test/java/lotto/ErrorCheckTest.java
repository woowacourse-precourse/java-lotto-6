package lotto;


import java.util.ArrayList;
import java.util.List;
import lotto.vo.winning.LottoWinning;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.service.errorchek.ErrorCheck;

public class ErrorCheckTest {
    @DisplayName("입력금액의 범위 오류 테스트")
    @Test
    void MoneyInput_범위_오류_테스트() {
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
    void MoneyInput_문자입력_테스트() {
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
    void MoneyInput_단위_오류_테스트() {
        String error_UnitConfirmation = "12424";
        try {
            ErrorCheck.MoneyInput(error_UnitConfirmation);
        } catch (IllegalArgumentException error) {
            Assertions.assertEquals("[ERROR] : 입력하신 구매액이 올바르지 않습니다.(구매액은 1000원 단위로만 판매함)", error.getMessage());
        }
    }

    //LottoWinning 관련
    @DisplayName("당첨로또 번호 개수 오류")
    @Test
    void WinnerNumberInput_테스트() {
        try {
            ErrorCheck.WinnerNumberInput("1,2,3,4,5,6,7");
        } catch (IllegalArgumentException error) {
            Assertions.assertEquals("[ERROR] : 로또 번호가 6개가아닙니다.", error.getMessage());
        }
    }

    @DisplayName("당첨 번호 문자 일 경우 오류")
    @Test
    void WinnerNumberInput_문자입력_테스트() {
        try {
            ErrorCheck.WinnerNumberInput("1,a,3,4,b,6");
        } catch (IllegalArgumentException error) {
            Assertions.assertEquals("[ERROR] : 입력하신 당첨 로또의 번호가 올바르지 않습니다.(숫자로 읽히지 않음)", error.getMessage());
        }
    }

    @DisplayName("당첨 번호 범위 오류")
    @Test
    void WinnerNumberInput_범위_테스트() {
        try {
            ErrorCheck.WinnerNumberInput("645,12412,0,4,5,7");
        } catch (IllegalArgumentException error) {
            Assertions.assertEquals("[ERROR] : 입력하신 당첨 로또의 번호의 범위가 알맞지 않습니다.", error.getMessage());
        }
    }

    @DisplayName("당첨 번호 중복 오류")
    @Test
    void WinnerNumberInput_중복오류_테스트() {
        try {
            ErrorCheck.WinnerNumberInput("1,1,2,3,4,5");
        } catch (IllegalArgumentException error) {
            Assertions.assertEquals("[ERROR] : 로또 번호를 중복 입력 하셨습니다.", error.getMessage());
        }
    }

    @DisplayName("당첨 보너스 번호 문자 일 경우 오류")
    @Test
    void BonusNumberInput_문자입력_테스트() {
        try {
            ErrorCheck.BonusNumberInput("64L");
        } catch (IllegalArgumentException error) {
            Assertions.assertEquals("[ERROR] : 입력하신 당첨 로또의 번호가 올바르지 않습니다.(숫자로 읽히지 않음)", error.getMessage());
        }
    }
    @DisplayName("당첨 보너스 번호 범위 오류")
    @Test
    void BonusNumberInput_범위_테스트() {
        try {
            ErrorCheck.BonusNumberInput("645");
        } catch (IllegalArgumentException error) {
            Assertions.assertEquals("[ERROR] : 입력하신 보너스 번호의 범위가 알맞지 않습니다.", error.getMessage());
        }
    }

    @DisplayName("당첨 보너스 번호 중복 오류")
    @Test
    void BonusNumberInput_중복오류_테스트() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        Lotto winningnumber = new Lotto(numbers);
        LottoWinning.setWinningnumber(winningnumber);
        try {
            ErrorCheck.BonusNumberInput("1");
        } catch (IllegalArgumentException error) {
            Assertions.assertEquals("[ERROR] : 로또 번호를 중복 입력 하셨습니다.", error.getMessage());
        }
    }
}
