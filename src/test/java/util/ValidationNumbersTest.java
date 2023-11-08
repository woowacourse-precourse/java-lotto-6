package util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationNumbersTest {

    @Test
    @DisplayName("리스트가 유효한 문자열로 변환되는지 테스트한다.")
    void listToString() {
        List<Integer> actual = List.of(1, 2, 3, 4, 5, 6);
        String expected = "1,2,3,4,5,6";
        assertEquals(expected, ValidationNumbers.listToString(actual));
    }

    @ParameterizedTest
    @DisplayName("당첨 번호가 숫자인지 테스트한다.")
    @ValueSource(strings = {"1,2,ㅁ,3,ㄷ", "a,s,e,r,c,", "1,a,3"})
    void validateNumber(String numberString) {
        IllegalArgumentException notANumberException = assertThrows(IllegalArgumentException.class, () -> {
            ValidationNumbers.validateNumber(numberString);
        });
        assertThat(notANumberException.getMessage())
                .isEqualTo(ValidationNumbersMessages.NOT_A_NUMBER.getMessage());
    }

    @ParameterizedTest
    @DisplayName("당첨 번호의 길이가 유효한지 테스트한다.")
    @ValueSource(strings = {"1,2,3", " ", "", "1,2,3,4,5,6,7"})
    void validateLength(String numberString) {
        IllegalArgumentException InvalidLengthException = assertThrows(IllegalArgumentException.class, () -> {
            ValidationNumbers.validateLength(numberString);
        });
        assertThat(InvalidLengthException.getMessage())
                .isEqualTo(ValidationNumbersMessages.INVALID_LENGTH.getMessage());
    }

    @ParameterizedTest
    @DisplayName("당첨 번호의 각 숫자가 1~45 이내인지 테스트한다.")
    @ValueSource(strings = {"0,1,2,3,4,5", "1,232,4353,2,423,6", "1,2,3,4,6,46", "1,2,3,47,6,7"})
    void validateNumberRange(String numberString) {
        IllegalArgumentException InvalidNumberException = assertThrows(IllegalArgumentException.class, () -> {
            ValidationNumbers.validateNumberRange(numberString);
        });
        assertThat(InvalidNumberException.getMessage())
                .isEqualTo(ValidationNumbersMessages.INVALID_NUMBER.getMessage());
    }

    @ParameterizedTest
    @DisplayName("당첨 번호의 각 숫자가 중복되는지 테스트한다.")
    @ValueSource(strings = {"1,1,2,3,4,5", "1,2,3,4,2,6", "1,2,3,4,5,1", "1,2,3,3,3,6"})
    void validateDuplicateNumber(String numberString) {
        IllegalArgumentException DuplicateNumberException = assertThrows(IllegalArgumentException.class, () -> {
            ValidationNumbers.validateDuplicateNumber(numberString);
        });
        assertThat(DuplicateNumberException.getMessage())
                .isEqualTo(ValidationNumbersMessages.DUPLICATE_NUMBER.getMessage());
    }

    @ParameterizedTest
    @DisplayName("당첨 번호의 입력이 유효하지 않은 입력인지 테스트한다.")
    @ValueSource(strings = {"1,1,2,3,4,5", "1,a,e,rㅁㄷ,3", "1,2,3,4", "1,2,3,4,5,46"})
    void validateNumbers(String numberString) {
        assertThatThrownBy(() -> ValidationNumbers.validateNumbers(numberString))
                .isInstanceOf(IllegalArgumentException.class);
    }


}