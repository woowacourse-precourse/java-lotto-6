package lotto.view;

import lotto.global.ResponseStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @DisplayName("구매한 금액이 1000의 배수인지 검사하는 기능 테스트")
    @Test
    void purchasePriceCheck() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.purchasePriceCheck(1500));
        assertEquals(ResponseStatus.OK, InputValidator.purchasePriceCheck(2000));
    }

    @DisplayName("빈 입력이나 null 입력에 대해 검사하는 기능 테스트")
    @Test
    void isInputValid() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isInputValid(""));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isInputValid(" "));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isInputValid(null));
        assertEquals(ResponseStatus.OK, InputValidator.isInputValid("123"));
    }

    @DisplayName("입력한 값이 (0~9) 사이의 정수인지 검사하는 기능 테스트")
    @Test
    void isInputDigit() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isInputDigit("abc"));
        assertEquals(ResponseStatus.OK, InputValidator.isInputDigit("123"));
    }

    @DisplayName("로또 길이가 올바른지 검사하는 기능 테스트")
    @Test
    void lottoLengthCheck() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.lottoLengthCheck(Arrays.asList(1, 2, 3, 4, 5)));
        assertEquals(ResponseStatus.OK, InputValidator.lottoLengthCheck(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 번호들가 빈 배열인지 검사하는 기능 테스트")
    @Test
    void lottoNumbersEmptyCheck() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.lottoNumbersEmptyCheck(new ArrayList<>()));
        assertEquals(ResponseStatus.OK, InputValidator.lottoNumbersEmptyCheck(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 번호가 중복되는지 검사하는 기능 테스트")
    @Test
    void lottoNumbersDuplicatedCheck() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.lottoNumbersDuplicatedCheck(Arrays.asList(1, 1, 2, 3, 4, 5)));
        assertEquals(ResponseStatus.OK, InputValidator.lottoNumbersDuplicatedCheck(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 번호가 1~45 범위를 벗어나는지 검사하는 기능 테스트")
    @Test
    void isLottoInRange() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isLottoInRange(0));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isLottoInRange(46));
        assertEquals(ResponseStatus.OK, InputValidator.isLottoInRange(45));
    }

    @DisplayName("보너스가 다른 로또 번호와 중복되는지 검사하는 기능 테스트")
    @Test
    void bonusDuplicateCheck() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.bonusDuplicateCheck(Arrays.asList(1, 2, 3, 4, 5, 6), 6));
        assertEquals(ResponseStatus.OK, InputValidator.bonusDuplicateCheck(Arrays.asList(1, 2, 3, 4, 5, 6), 7));
    }
}