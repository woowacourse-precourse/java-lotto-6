package lotto.model.validator;

import static lotto.util.ExceptionMessage.BIGGER_THAN_MAX_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.BLANK_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.INVALID_NUMBER_OF_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.SMALLER_THAN_MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoNumberValidatorImplTest {
    WinningNumberValidator lottoNumberValidator;

    @BeforeEach
    void beforeEach() {
        lottoNumberValidator = new WinningNumberValidator();
    }

    static Stream<List> generateGoodLottoNumber() {
        return Stream.of(
                Arrays.asList("1", "2", "3", "4", "5", "6"),
                Arrays.asList("45", "44", "43", "42", "41", "40")
        );
    }

    @ParameterizedTest
    @MethodSource("generateGoodLottoNumber")
    @DisplayName("6개의 문자가 입력된다면 어떠한 Exception도 감지되지 않는다.")
    void sixStringsTest(List<String> lottoNumbers) {
        // given
        // when & then
        assertThatNoException().isThrownBy(() -> lottoNumberValidator.checkNumberOfLottoNumbers(lottoNumbers));
    }


    @ParameterizedTest
    @MethodSource("generateNotSixLottoNumber")
    @DisplayName("6개의 문자가 입력되지 않을 경우 IllegalArgumentException을 반환한다.")
    void notSixLottoNumberTest(List<String> lottoNumbers) {
        // given
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoNumberValidator.checkNumberOfLottoNumbers(lottoNumbers))
                .withMessage(INVALID_NUMBER_OF_LOTTO_NUMBER.getMessage());
    }

    static Stream<List> generateNotSixLottoNumber() {
        return Stream.of(
                Arrays.asList("1", "2", "3", "4", "5", "6", "7"),
                Arrays.asList("45", "44", "43", "42", "41"),
                Arrays.asList("1")
        );
    }

    @ParameterizedTest
    @MethodSource("generateGoodLottoNumber")
    @DisplayName("공백이 없는 문자가 들어오는 경우 어떠한 Exception도 감지되지 않는다.")
    void notBlankLottoNumberTest(List<String> lottoNumbers) {
        // given
        // when & then
        assertThatNoException().isThrownBy(() -> lottoNumberValidator.checkBlankOfLottoNumbers(lottoNumbers));
    }

    @ParameterizedTest
    @MethodSource("generateBlankLottoNumber")
    @DisplayName("공백이 있는 문자가 들어오는 경우 IllegalArgumnetException을 반환한다.")
    void blankLottoNumberTest(List<String> lottoNumbers) {
        // given
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoNumberValidator.checkBlankOfLottoNumbers(lottoNumbers))
                .withMessage(BLANK_LOTTO_NUMBER.getMessage());
    }

    static Stream<List> generateBlankLottoNumber() {
        return Stream.of(
                Arrays.asList("1", " ", "3", "4", "5", "6"),
                Arrays.asList(" ", "44", "43", "42", "41", "40"),
                Arrays.asList("1", "1", "1", "1", "1", "")
        );
    }

    static Stream<List> convertedGoodLottoNumber() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(45, 44, 43, 42, 41, 40)
        );
    }

    @ParameterizedTest
    @MethodSource("convertedGoodLottoNumber")
    @DisplayName("1 ~ 45 내의 숫자라면 어떠한 Exception도 감지되지 않는다.")
    void lottoNumberIsInRangeTest(List<Integer> lottoNumbers) {
        // given
        // when & then
        assertThatNoException().isThrownBy(() -> lottoNumberValidator.checkInRangeOfLottoNumbers(lottoNumbers));
    }

    @ParameterizedTest
    @MethodSource("convertedOutOfRangeLottoNumber")
    @DisplayName("1 미만의 숫자라면 IllegalArgumentException을 반환한다.")
    void lottoNumberIsOutOfRangeTest(List<Integer> lottoNumbers, String expectedExceptionMessage) {
        // given
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoNumberValidator.checkInRangeOfLottoNumbers(lottoNumbers))
                .withMessage(expectedExceptionMessage);
    }

    static Stream<Arguments> convertedOutOfRangeLottoNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(-1, 2, 3, 4, 5, 6), SMALLER_THAN_MIN_LOTTO_NUMBER.getMessage()),
                Arguments.of(Arrays.asList(1, 2, 0, 4, 5, 6), SMALLER_THAN_MIN_LOTTO_NUMBER.getMessage()),
                Arguments.of(Arrays.asList(4, 15, 7, 23, 29, 46), BIGGER_THAN_MAX_LOTTO_NUMBER.getMessage())
        );
    }

    @ParameterizedTest
    @MethodSource("convertedGoodLottoNumber")
    @DisplayName("중복되지 않은 입력이라면 어떠한 Exception도 감지되지 않는다.")
    void notDuplicateLottoNumberTest(List<Integer> lottoNumbers) {
        // given
        // when & then
        assertThatNoException().isThrownBy(() -> lottoNumberValidator.checkDuplicateLottoNumbers(lottoNumbers));
    }

    @ParameterizedTest
    @MethodSource("convertedDuplicateLottoNumber")
    @DisplayName("중복된 입력이라면 IllegalArgumentException을 반환한다.")
    void duplicateLottoNumberTest(List<Integer> lottoNumbers) {
        // given
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoNumberValidator.checkDuplicateLottoNumbers(lottoNumbers))
                .withMessage(DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    static Stream<List> convertedDuplicateLottoNumber() {
        return Stream.of(
                Arrays.asList(1, 2, 1, 4, 5, 6),
                Arrays.asList(45, 45, 45, 45, 45, 45)
        );
    }
}