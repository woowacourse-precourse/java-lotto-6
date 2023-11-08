package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = new WinningNumbers(List.of("1", "2", "3", "4", "5", "6"));
    }

    @Test
    @DisplayName("보너스 넘버가 이미 당첨번호에 존재할 시 예외가 발생한다.")
    void validateDuplication() {
        assertThatThrownBy(() -> winningNumbers.validateDuplication(1)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("당첨번호와 로또의 일치하는 번호의 갯수를 센다.")
    @CsvSource(value = {"1,2,3,4,5,6,6","1,2,3,4,5,10,5","1,2,3,4,10,11,4"})
    void countMatchedNumber(int num1, int num2,int num3,int num4,int num5,int num6, int expect) {
        //given
        Lotto lotto = new Lotto(List.of(num1, num2, num3, num4, num5, num6));

        //when

        //then
        assertThat(winningNumbers.countMatchedNumber(lotto)).isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("빈칸 입력시 예외가 발생한다.")
    @ValueSource(strings = {" ,2,3,4,5,6", " 1,2,3,4,5,6", "1 ,2,3,4,5,6"})
    void noBlankTest(String userInput) {
        //given
        List<String> userInputForTest = Arrays.stream(userInput.split(",")).collect(Collectors.toList());

        //when

        //then
        assertThatThrownBy(() -> new WinningNumbers(userInputForTest))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("숫자 외 문자를 입력시 예외가 발생한다.")
    @ValueSource(strings = {"-1,2,3,4,5,6", "1a,2,3,4,5,6", "a1,2,3,4,5,6"})
    void onlyNumbersTest(String userInput) {
        //given
        List<String> userInputForTest = Arrays.stream(userInput.split(",")).collect(Collectors.toList());

        //when

        //then
        assertThatThrownBy(() -> new WinningNumbers(userInputForTest))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("6자리 숫자가 아닐시 예외가 발생한다.")
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5", "1,2,3"})
    void numbersSizeSixTest(String userInput) {
        //given
        List<String> userInputForTest = Arrays.stream(userInput.split(",")).collect(Collectors.toList());

        //when

        //then
        assertThatThrownBy(() -> new WinningNumbers(userInputForTest))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("1 ~ 45 범위를 벗어날시 예외가 발생한다.")
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
    void numberRangeTest(String userInput) {
        //given
        List<String> userInputForTest = Arrays.stream(userInput.split(",")).collect(Collectors.toList());

        //when

        //then
        assertThatThrownBy(() -> new WinningNumbers(userInputForTest))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("중복된 숫자를 포함시 예외가 발생한다.")
    @ValueSource(strings = {"1,2,3,4,5,5", "1,1,2,3,4,5"})
    void duplicatedNumberTest(String userInput) {
        //given
        List<String> userInputForTest = Arrays.stream(userInput.split(",")).collect(Collectors.toList());

        //when

        //then
        assertThatThrownBy(() -> new WinningNumbers(userInputForTest))
                .isInstanceOf(IllegalArgumentException.class);
    }
}