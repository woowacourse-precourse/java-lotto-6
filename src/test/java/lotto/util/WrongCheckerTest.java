package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WrongCheckerTest {
    WrongChecker wrongChecker;

    @BeforeEach
    void beforeEach() {
        wrongChecker = new WrongChecker();
    }

    //checkWrongAmount() 테스트
    @Test
    void 잘못된구입금액테스트() {
        //given
        String testStr1 = "123aa";
        String testStr2 = "1234444";
        boolean result = false;
        //when
        result = wrongChecker.checkWrongAmount(testStr1);
        result = wrongChecker.checkWrongAmount(testStr2);
        //then
        Assertions.assertFalse(result);
    }

    //checkAmountCharacter() 테스트
    @Test
    void 잘못된구입금액문자입력시() {
        //given
        String testStr = "123aaa";
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wrongChecker.checkAmountCharacter(testStr);
        });
    }

    //checkAmountCharacter() 테스트
    @Test
    void 올바른구입금액문자입력시() {
        //given
        String testStr = "10000";
        //when, then
        Assertions.assertDoesNotThrow(() -> {
            wrongChecker.checkAmountCharacter(testStr);
        });
    }

    //checkAmountUnit() 테스트
    @Test
    void 잘못된구입금액입력시() {
        //given
        String testStr = "12345";
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wrongChecker.checkAmountUnit(testStr);
        });
    }

    //checkAmountUnit() 테스트
    @Test
    void 올바른구입금액입력시() {
        //given
        String testStr = "10000";
        //when, then
        Assertions.assertDoesNotThrow(() -> {
            wrongChecker.checkAmountUnit(testStr);
        });
    }

    //checkWrongWiningNumberInput() 테스트
    @Test
    void 당첨번호종합테스트() {
        //given
        String testStr = "11,12,13,14,13,16";
        //when, then
        Assertions.assertDoesNotThrow(() -> {
            wrongChecker.checkWrongWiningNumberInput(testStr);
        });
    }
    //checkWiningNumberRange() 테스트
    @Test
    void 잘못된당첨번호숫자범위테스트() {
        //given
        String testStr = "11,40,1119";
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wrongChecker.checkWiningNumberRange(testStr);
        });
    }

    //checkWiningNumberCharacter() 테스트
    @Test
    void 잘못된당첨번호문자입력테스트() {
        //given
        String testStr = "111213,1324,aaa";
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wrongChecker.checkWiningNumberCharacter(testStr);
        });
    }

    //checkWiningNumberSize() 테스트
    @Test
    void 잘못된당첨번호갯수입력테스트() {
        //given
        String testStr = "11,22,33,44,55";
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wrongChecker.checkWiningNumberSize(testStr);
        });
    }

    //checkDoubleWiningNumber() 테스트
    @Test
    void 중복당첨번호입력테스트() {
        //given
        String testStr = "11,22,33,33,55,66";
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wrongChecker.checkDoubleWiningNumber(testStr);
        });
    }
    //checkWrongBonusNumber() 테스트
    @Test
    void 보너스번호입력에러종합테스트() {
        //given
        String testStr = "13";
        List<Integer> testList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        //when, then
        Assertions.assertDoesNotThrow(() -> {
            wrongChecker.checkWrongBonusNumber(testList, testStr);
        });
    }

    //checkBonusNumberCharacter() 테스트
    @Test
    void 보너스번호잘못된문자입력테스트() {
        //given
        String testStr = "aa";
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wrongChecker.checkBonusNumberCharacter(testStr);
        });
    }

    //checkBonusNumberRange() 테스트
    @Test
    void 보너스번호잘못된숫자범위입력테스트() {
        //given
        String testStr = "0";
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wrongChecker.checkBonusNumberRange(testStr);
        });
    }

    //checkDoubleBonusNumber() 테스트
    @Test
    void 보너스번호중복된숫자테스트() {
        //given
        String testStr = "2";
        List<Integer> testList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wrongChecker.checkDoubleBonusNumber(testList, testStr);
        });
    }
}