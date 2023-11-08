package lotto.validator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @Test
    @DisplayName("숫자가 아닌 입력이 들어오면, 예외가 발생한다.")
    void testInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsNumber("ab"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsNumber("0.1"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsNumber("1 2"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsNumber(""));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsNumber(" "));
    }

    @Test
    @DisplayName("숫자인 입력이 들어오면, 예외가 발생하지 않는다.")
    void testValidNumber() {
        assertDoesNotThrow(() -> InputValidator.validateIsNumber("123"));
        assertDoesNotThrow(() -> InputValidator.validateIsNumber("0"));
        assertDoesNotThrow(() -> InputValidator.validateIsNumber("-456"));
    }

    @Test
    @DisplayName("구매 단위에 맞지 않은 입력이 들어오면, 예외를 발생시킨다.")
    void testInvalidateIsMultiplesOfSingleLottoPrice() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsMultiplesOfSingleLottoPrice(1050));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsMultiplesOfSingleLottoPrice(1));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsMultiplesOfSingleLottoPrice(10));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsMultiplesOfSingleLottoPrice(-1));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsMultiplesOfSingleLottoPrice(-1000));
    }

    @Test
    @DisplayName("구매 단위에 맞지 입력이 들어오면, 예외를 발생시키지 않는다.")
    void testValidateIsMultiplesOfSingleLottoPrice() {
        assertDoesNotThrow(() -> InputValidator.validateIsMultiplesOfSingleLottoPrice(0));
        assertDoesNotThrow(() -> InputValidator.validateIsMultiplesOfSingleLottoPrice(1000));
        assertDoesNotThrow(() -> InputValidator.validateIsMultiplesOfSingleLottoPrice(2000));
        assertDoesNotThrow(() -> InputValidator.validateIsMultiplesOfSingleLottoPrice(10000));
        assertDoesNotThrow(() -> InputValidator.validateIsMultiplesOfSingleLottoPrice(1000000));
    }

    @Test
    @DisplayName("입력 중에 숫자가 아닌 값이 하나라도 있으면, 예외를 발생시킨다.")
    void testInvalidNumbers(){
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsNumbers(List.of("a","b")));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsNumbers(List.of(" ","1")));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsNumbers(List.of("1"," ")));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsNumbers(List.of("0.1"," ")));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsNumbers(List.of("0.1","a ")));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsNumbers(List.of("")));
    }

    @Test
    @DisplayName("입력 중에 숫자인 입력만 들어오면, 예외가 발생하지 않는다.")
    void testValidNumbers(){
        assertDoesNotThrow(() -> InputValidator.validateIsNumbers(List.of("1","2","3")));
        assertDoesNotThrow(() -> InputValidator.validateIsNumbers(List.of("0","1","2")));
        assertDoesNotThrow(() -> InputValidator.validateIsNumbers(List.of("-1","-2","3")));
    }

    @Test
    @DisplayName("입력 중에 중복되는 값이 하나라도 있으면, 예외를 발생시킨다.")
    void testInvalidateUniqueNumbers() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateUniqueNumbers(List.of(1,1,3,4,5,6)));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateUniqueNumbers(List.of(1,2,1,4,5,6)));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateUniqueNumbers(List.of(1,2,3,1,5,6)));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateUniqueNumbers(List.of(1,2,3,4,1,6)));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateUniqueNumbers(List.of(1,2,3,4,5,1)));

        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateUniqueNumbers(List.of(1,2,3,4,5,1),6));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateUniqueNumbers(List.of(1,2,3,4,5,1),6));

        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateUniqueNumbers(List.of(1,2,3,4,5,6),4));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateUniqueNumbers(List.of(1,2,3,4,5,6),5));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateUniqueNumbers(List.of(1,2,3,4,5,6),6));
    }

    @Test
    @DisplayName("입력 중에 중복되는 값이 없으면 예외가 발생하지 않는다.")
    void testValidateUniqueNumbers() {
        assertDoesNotThrow(() -> InputValidator.validateUniqueNumbers(List.of(1,2,3,4,5,6)));
        assertDoesNotThrow(() -> InputValidator.validateUniqueNumbers(List.of(12,2,3,4,5,6)));
        assertDoesNotThrow(() -> InputValidator.validateUniqueNumbers(List.of(14,26,42,43,44)));

        assertDoesNotThrow(() -> InputValidator.validateUniqueNumbers(List.of(1,2,3,4,5,6),7));
        assertDoesNotThrow(() -> InputValidator.validateUniqueNumbers(List.of(12,2,3,4,5,6),10));
        assertDoesNotThrow(() -> InputValidator.validateUniqueNumbers(List.of(14,26,42,43,44),45));
    }

    @Test
    @DisplayName("입력 중에 로또 숫자의 범위 밖에 있는 값이 존재하면,예외가 발생한다.")
    void testInvalidateInLottoRange() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInLottoRange(List.of(0,1,3,4,5,6)));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInLottoRange(List.of(1,2,0,4,5,6)));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInLottoRange(List.of(1,2,3,46,5,6)));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInLottoRange(List.of(1,2,3,4,100,6)));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInLottoRange(List.of(1,2,-1,4,5,6)));

        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInLottoRange(0));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInLottoRange(-1));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInLottoRange(46));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInLottoRange(10000));
    }

    @Test
    @DisplayName("입력 중에 로또 숫자의 범위 안에 포함되어 있으면,예외가 발생하지 않는다.")
    void testValidateInLottoRange() {
        assertDoesNotThrow(() -> InputValidator.validateInLottoRange(List.of(1,2,3,4,5,6)));
        assertDoesNotThrow(() -> InputValidator.validateInLottoRange(List.of(12,2,3,4,5,6)));
        assertDoesNotThrow(() -> InputValidator.validateInLottoRange(List.of(14,26,42,43,44)));

        assertDoesNotThrow(() -> InputValidator.validateInLottoRange(1));
        assertDoesNotThrow(() -> InputValidator.validateInLottoRange(20));
        assertDoesNotThrow(() -> InputValidator.validateInLottoRange(45));
    }

    @Test
    @DisplayName("입력의 사이즈가 로또 사이즈와 다르면,예외가 발생한다.")
    void testInvalidateIsLottoSize() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsLottoSize(List.of()));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsLottoSize(List.of(6)));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsLottoSize(List.of(1,2,3,4,5,6,7)));
    }

    @Test
    @DisplayName("입력의 사이즈가 로또 사이즈와 같으면,예외가 발생하지 않는다.")
    void testValidateIsLottoSize() {
        assertDoesNotThrow(() -> InputValidator.validateIsLottoSize(List.of(1,2,3,4,5,6)));
        assertDoesNotThrow(() -> InputValidator.validateIsLottoSize(List.of(11,12,13,14,15,16)));
    }
}