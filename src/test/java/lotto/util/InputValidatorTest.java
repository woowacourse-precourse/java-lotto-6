package lotto.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {
    public static InputValidator inputValidator;
    @BeforeAll
    static void initializer(){
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"5", "12", "43"})
    @DisplayName("사용자_입력_숫자형_통과_테스트")
    void valid_isNumericValidator(String input) {
        // given
        Boolean isValid;
        // when
        isValid = inputValidator.isNumericValidator(input);
        // then
        assertThat(isValid).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"만오천", "14000원", "  12000"})
    @DisplayName("사용자_입력_숫자형_불통과_테스트")
    void invalid_isNumericValidator(String input) {
        // given
        // when & then
        assertThatThrownBy(()->inputValidator.isNumericValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력은 숫자 형태여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {10000, 20000, 55000})
    @DisplayName("금액_입력_1000원_단위_통과_테스트")
    void valid_isThousandUnitValidator(Integer money) {
        // given
        Boolean isValid;
        // when
        isValid = inputValidator.isThousandUnitValidator(money);
        // then
        assertThat(isValid).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {500, 3480, 55500})
    @DisplayName("금액_입력_1000원_단위_불통과_테스트")
    void invalid_isThousandUnitValidator(Integer money) {
        // given
        // when & then
        assertThatThrownBy(()->inputValidator.isThousandUnitValidator(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 금액은 1,000원 단위여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45, 30})
    @DisplayName("당첨번호_입력_유효한_범위_테스트")
    void valid_isInRangeValidator(Integer number) {
        // given
        Boolean isValid;
        // when
        isValid = inputValidator.isInRangeValidator(number);
        // then
        assertThat(isValid).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100})
    @DisplayName("당첨번호_입력_유효하지_못한_범위_테스트")
    void invalid_isInRangeValidator(Integer number) {
        // given
        // when & then
        assertThatThrownBy(()->inputValidator.isInRangeValidator(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("provideValidNumberList")
    @DisplayName("6개_당첨번호_입력_중복_통과_테스트")
    void valid_isNotOverlapSixValidator(List<Integer> numbers) {
        // given
        Boolean isValid;
        // when
        isValid = inputValidator.isNotOverlapSixValidator(numbers);
        // then
        assertThat(isValid).isEqualTo(true);
    }

    @ParameterizedTest
    @MethodSource("provideInvalidNumberList")
    @DisplayName("6개_당첨번호_입력_중복_불통과_테스트")
    void invalid_isNotOverlapSixValidator(List<Integer> numbers) {
        // given
        // when & then
        assertThatThrownBy(()->inputValidator.isNotOverlapSixValidator(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개의 숫자에 중복된 로또 번호가 존재합니다.");
    }

    @ParameterizedTest
    @MethodSource("provideValidNumberListWithBonus")
    @DisplayName("보너스_번호_입력_중복_통과_테스트")
    void valid_isNotOverlapBonusValidator(List<Integer> numbers, Integer bonusNumber) {
        // given
        Boolean isValid;
        // when
        isValid = inputValidator.isNotOverlapBonusValidator(numbers, bonusNumber);
        // then
        assertThat(isValid).isEqualTo(true);
    }

    @ParameterizedTest
    @MethodSource("provideInvalidNumberListWithBonus")
    @DisplayName("보너스_번호_입력_중복_불통과_테스트")
    void invalid_isNotOverlapBonusValidator(List<Integer> numbers, Integer bonusNumber) {
        // given
        // when & then
        assertThatThrownBy(()->inputValidator.isNotOverlapBonusValidator(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호와 중복된 로또 번호가 존재합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2400, 1})
    @DisplayName("금액_입력_최솟값_통과_테스트")
    void valid_isMinimumValidator(Integer money) {
        // given
        Boolean isValid;
        // when
        isValid = inputValidator.isMinimumValidator(money);
        // then
        assertThat(isValid).isEqualTo(true);
    }

    @Test
    @DisplayName("금액_입력_최솟값_통과_테스트")
    void invalid_isMinimumValidator() {
        // given
        Integer money = 0;
        // when & then
        assertThatThrownBy(()->inputValidator.isMinimumValidator(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 금액은 최소 0원보다 커야 합니다.");
    }

    // @MethodSource 어노테이션 이용을 위한 메서드
    private static Stream<Arguments> provideValidNumberList(){
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6)),
                Arguments.of(Arrays.asList(5,30,31,29,17,15)),
                Arguments.of(Arrays.asList(15,2,37,43,45,33))
        );
    }

    private static Stream<Arguments> provideInvalidNumberList(){
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,2,2,5,6)),
                Arguments.of(Arrays.asList(5,30,5,29,17,15)),
                Arguments.of(Arrays.asList(44,2,44,44,44,44))
        );
    }

    private static Stream<Arguments> provideValidNumberListWithBonus(){
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6), 8),
                Arguments.of(Arrays.asList(5,30,31,29,17,15), 8),
                Arguments.of(Arrays.asList(15,2,37,43,45,33), 8)
        );
    }

    private static Stream<Arguments> provideInvalidNumberListWithBonus(){
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,2,2,5,6), 5),
                Arguments.of(Arrays.asList(5,30,5,29,17,15), 30),
                Arguments.of(Arrays.asList(44,2,44,44,44,44), 2)
        );
    }
}