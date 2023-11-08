package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoException;
import lotto.utils.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    @Test
    @DisplayName("빈 문자열이나 null 입력에 대해 예외를 발생시킨다.")
    void validateEmpty_WhenInputIsEmptyOrNull_ThrowsException() {
        assertAll(
                () -> assertThrows(LottoException.class, () -> Validator.validateEmpty("")),
                () -> assertThrows(LottoException.class, () -> Validator.validateEmpty((String) null))
        );
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("빈 리스트나 null 입력에 대해 예외를 발생시킨다.")
    void validateEmpty_WhenInputListIsEmptyOrNull_ThrowsException(String nullAndEmpty) {
        assertThatThrownBy(() -> Validator.validateEmpty(nullAndEmpty)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0이 입력되면 예외를 발생시킨다.")
    void validateZero_WhenInputIsZero_ThrowsException() {
        int number = 0;
        assertThrows(LottoException.class, () -> Validator.validateZero(number));
    }

    @Test
    @DisplayName("입력된 번호의 길이가 로또 번호 길이와 다를 경우 예외를 발생시킨다.")
    void validateLength_WhenInputLengthIsInvalid_ThrowsException() {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5); // 로또 번호는 보통 6개여야 함

        assertThrows(LottoException.class, () -> Validator.validateLength(inputNumbers));
    }

    @Test
    @DisplayName("리스트에 특정 번호가 이미 존재할 경우 예외를 발생시킨다.")
    void validateUniqueValue_WhenNumberIsAlreadyInList_ThrowsException() {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int number = 1;

        assertThrows(LottoException.class, () -> Validator.validateUniqueValue(inputNumbers, number));
    }

    @Test
    @DisplayName("중복된 값을 가진 리스트에 대해 예외를 발생시킨다.")
    void validateUniqueValue_WhenInputHasDuplicates_ThrowsException() {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 3, 4, 5, 6);

        assertThrows(LottoException.class, () -> Validator.validateUniqueValue(inputNumbers));
    }

    @Test
    @DisplayName("번호가 범위를 벗어날 경우 예외를 발생시킨다.")
    void validateNumberRange_WhenNumberIsOutOfBound_ThrowsException() {
        int number = 46;
        assertThrows(LottoException.class, () -> Validator.validateNumberRange(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"일", "one", "1일", "::"})
    @DisplayName("숫자가 아닌 입력에 대해 예외를 발생시킨다.")
    void validateNumber_WhenInputIsNotNumber_ThrowsException(String input) {
        assertThatThrownBy(() -> Validator.validateNumber(input)).isInstanceOf(LottoException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.2.3.4.5.6", "1:2:3:4:5:6"})
    @DisplayName("잘못된 형식의 문자열에 대해 예외를 발생시킨다.")
    void validateFormat_WhenInputIsInvalidFormat_ThrowsException(String input) {
        assertThatThrownBy(() -> Validator.validateFormat(input)).isInstanceOf(LottoException.class);
    }
    @Test
    @DisplayName("가격이 로또 티켓 가격의 배수가 아닐 경우 예외를 발생시킨다.")
    void validatePrice_WhenPriceIsNotMultipleOfTicketPrice_ThrowsException() {
        int price = 1500;
        assertThrows(LottoException.class, () -> Validator.validatePrice(price));
    }
}
