package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.message.ExceptionMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "10,20,30,40,50"})
    @DisplayName("리스트의 크기가 6이 아니면 오류 발생")
    void givenInvalidSizeNumbers_thenThrowsException(String input) {
        // when
        List<Integer> numbers = convertStringToList(input);

        // then
        IllegalArgumentException exception = org.junit.jupiter.api.Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Lotto(numbers)
        );
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.ERROR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,3,4,5,6", "10,20,30,30,50,60"})
    @DisplayName("리스트에 중복된 값이 있으면 오류 발생")
    void givenDuplicateNumbers_thenThrowsException(String input) {
        // when
        List<Integer> numbers = convertStringToList(input);

        // then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Lotto(numbers)
        );
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.ERROR.getMessage());
    }

    @Test
    @DisplayName("유효한 로또 번호로 객체 생성")
    void givenValidLottoNumbers_thenCreateObject() {
        // given
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(validNumbers);

        // then
        assertThat(lotto.getLottoNumbers()).isEqualTo(validNumbers);
    }

    private List<Integer> convertStringToList(String input) {
        String[] parts = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String part : parts) {
            numbers.add(Integer.parseInt(part));
        }
        return numbers;
    }
}