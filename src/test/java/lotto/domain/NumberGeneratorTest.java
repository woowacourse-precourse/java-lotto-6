package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @ParameterizedTest
    @DisplayName("당첨번호가 정상적으로 입력되면 예외가 발생하지 않는다.")
    @ValueSource(strings = {"1,2,3,4,5,6", "1,10,20,30,40,45"})
    void givenGoodWinningNumbers_thenSuccess(final String winningNumbers){
        // given
        NumberGenerator numberGenerator = new NumberGenerator();

        // when & then
        Assertions.assertThatCode(() -> numberGenerator.createWinningNumbers(winningNumbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("당첨번호가 6자리인지 확인한다.")
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void winningNumbersSixLengthTest(final String numbers){
        // given
        NumberGenerator numberGenerator = new NumberGenerator();

        // when
        List<Integer> winningNumbers = numberGenerator.createWinningNumbers(numbers);

        // then
        Assertions.assertThat(winningNumbers.size()).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("당첨 번호 범위 테스트")
    @ValueSource(strings = {"1,2,3,4,5,6", "10,20,25,30,35,40"})
    void winningNumberRangeTest(final String numbers) {
        // given
        NumberGenerator numberGenerator = new NumberGenerator();

        // when
        List<Integer> winningNumbers = numberGenerator.createWinningNumbers(numbers);

        // then
        assertThat(winningNumbers.stream().allMatch(v -> v  >= 1 && v <= 45)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("보너스 번호 범위 테스트")
    @MethodSource("paramsForBonusNumberRangeTest")
    void bonusNumberRangeTest(final List<Integer> winningNumbers, final String bonusNumber) {
        // given
        NumberGenerator numberGenerator = new NumberGenerator();

        // when & then
        Assertions.assertThatCode(() -> numberGenerator.createBonusNumber(winningNumbers, bonusNumber))
                .doesNotThrowAnyException();
    }

    private static Stream<Arguments> paramsForBonusNumberRangeTest(){
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,6), "7"),
                Arguments.of(List.of(1,2,3,4,5,6), "45"));
    }

    @ParameterizedTest
    @DisplayName("보너스 번호 중복 테스트")
    @MethodSource("paramsForBonusNumberDuplicateTest")
    void bonusNumberDuplicateTest(final List<Integer> winningNumbers, final String bonusNumber) {
        // given
        NumberGenerator numberGenerator = new NumberGenerator();

        // when & then
        Assertions.assertThatCode(() -> numberGenerator.createBonusNumber(winningNumbers, bonusNumber))
                .doesNotThrowAnyException();
    }

    private static Stream<Arguments> paramsForBonusNumberDuplicateTest(){
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,6), "7"));
    }








}