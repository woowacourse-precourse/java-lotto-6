package lotto.utility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HandlingTest {

    @DisplayName("입력된 로또를 쉼표로 구분하여 문자열 리스트로 분리하기")
    @Test
    void splitLottoNumber() {
        // given
        String lotto = "1,2,3,4,5,6";

        // when, then
        assertThat(Handling.split(lotto)).isEqualTo(List.of("1", "2", "3", "4", "5", "6"));
    }

    @DisplayName("입력 마지막에 쉼표가 있을 때, 예외 처리")
    @Test
    void splitLottoNumberByLastComma() {
        // given
        String lotto = "1,2,3,4,5,6,";

        // when, then
        assertThatThrownBy(() -> Handling.split(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("String 리스트를 Integer 리스트로 변환")
    @Test
    void parseNumbers() {
        // given
        List<String> lotto = List.of("1", "2", "3", "4", "5", "6");

        // when, then
        assertThat(Handling.parseNumbers(lotto)).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("변환하는 값이 숫자가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"a,1,2,3,4,5", "1, ,3,4,5,6"})
    void parseNumbersByNotNumber(String userInput) {
        // given
        List<String> lotto = Handling.split(userInput);

        // when, then
        assertThatThrownBy(() -> Handling.parseNumbers(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("변환하는 값이 양수가 아닐 때, 예외 처리")
    @Test
    void parseNumbersByNotPositiveNumber() {
        // given
        List<String> lotto = List.of("1.5", "2", "3", "4", "5", "6");

        // when, then
        assertThatThrownBy(() -> Handling.parseNumbers(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("변환하는 값이 로또 번호 범위가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "46,45", "-1,2,3,4,5,6"})
    void parseNumbersByNotRange(String userInput) {
        // given
        List<String> lotto = Handling.split(userInput);

        // when, then
        assertThatThrownBy(() -> Handling.parseNumbers(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("변환하는 값앞에 0이 붙을 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"01,2,3,4,5,6", "010"})
    void parseNumbersByFirstNumberZero(String userInput) {
        // given
        List<String> lotto = Handling.split(userInput);

        // when, then
        assertThatThrownBy(() -> Handling.parseNumbers(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}