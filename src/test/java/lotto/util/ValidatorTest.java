package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.config.LottoConfig;
import lotto.dto.request.BonusNumberDto;
import lotto.dto.request.WinningNumbersDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ValidatorTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Nested
    @DisplayName("정수 변환 검증")
    class IntegerConversionTests {

        @Test
        @DisplayName("유효한 숫자 문자열")
        void validateAndParseInteger_Valid() {
            String input = "100";
            int result = Validator.validateAndParseInteger(input);
            assertThat(result).isEqualTo(100);
        }

        @Test
        @DisplayName("숫자가 아닌 문자열")
        void validateAndParseInteger_Invalid() {
            String input = "abc";
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.validateAndParseInteger(input))
                    .withMessageContaining(ERROR_MESSAGE);
        }
    }

    @Nested
    @DisplayName("Null 검증")
    class NullValidationTests {

        @Test
        @DisplayName("값의 null 여부 검증")
        void validateNotNull_NotNull() {
            Object notNullObject = new Object();
            assertThat(notNullObject).isNotNull();
        }

        @Test
        @DisplayName("값이 null일 때 예외 발생")
        void validateNotNull_Null() {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.validateNotNull(null));
        }
    }

    @Nested
    @DisplayName("숫자 범위 검증")
    class NumberRangeValidationTests {

        @Test
        @DisplayName("유효 범위 내")
        void validateNumberInRange_Valid() {
            Validator.validateNumberInRange(10); // LottoConfig 범위 내 값
            assertThat(10)
                    .isBetween(LottoConfig.START_OF_LOTTO_NUMBER.getValue(), LottoConfig.END_OF_LOTTO_NUMBER.getValue());
        }

        @Test
        @DisplayName("유효 범위 외")
        void validateNumberInRange_Invalid() {
            int invalidNumber = LottoConfig.END_OF_LOTTO_NUMBER.getValue() + 1;
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.validateNumberInRange(invalidNumber))
                    .withMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("최소 범위보다 작은 숫자")
        void validateNumberInRange_TooLow() {
            int tooLowNumber = LottoConfig.START_OF_LOTTO_NUMBER.getValue() - 1;
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.validateNumberInRange(tooLowNumber))
                    .withMessageContaining(ERROR_MESSAGE);
        }
    }

    @Nested
    @DisplayName("숫자 리스트 범위 검증")
    class NumberListRangeValidationTests {

        @Test
        @DisplayName("모두 유효 범위 내")
        void validateNumbersInRange_AllValid() {
            List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40, 45); // LottoConfig 범위 내 값들
            Validator.validateNumbersInRange(numbers);
            assertThat(numbers).allMatch(num ->
                    num >= LottoConfig.START_OF_LOTTO_NUMBER.getValue() &&
                            num <= LottoConfig.END_OF_LOTTO_NUMBER.getValue());
        }

        @Test
        @DisplayName("유효 범위를 벗어난 숫자 포함")
        void validateNumbersInRange_ContainsInvalid() {
            List<Integer> numbers = Arrays.asList(0, 10, 20, 30, 40, 46); // 0과 46은 LottoConfig 범위 외
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.validateNumbersInRange(numbers))
                    .withMessageContaining(ERROR_MESSAGE);
        }
    }

    @Nested
    @DisplayName("숫자 리스트 중복 검증")
    class NumberListUniquenessValidationTests {

        @Test
        @DisplayName("중복 없음")
        void validateUniqueNumbers_NoDuplicates() {
            List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40, 45);
            Validator.validateUniqueNumbers(numbers);
            assertThat(numbers).doesNotHaveDuplicates();
        }

        @Test
        @DisplayName("중복 포함")
        void validateUniqueNumbers_WithDuplicates() {
            List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40, 40);
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.validateUniqueNumbers(numbers))
                    .withMessageContaining(ERROR_MESSAGE);
        }
    }

    @Nested
    @DisplayName("당첨 번호 검증")
    class WinningNumberValidationTests {

        @Test
        @DisplayName("유효한 당첨 번호")
        void validateWinningNumbers_Valid() {
            List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40, 45);
            WinningNumbersDto dto = WinningNumbersDto.from(numbers);
            Validator.validateWinningNumbers(dto);
        }

        @Test
        @DisplayName("당첨 번호의 크기가 잘못됨")
        void validateWinningNumbers_InvalidSize() {
            List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40); // 6개가 아님
            WinningNumbersDto dto = WinningNumbersDto.from(numbers);
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.validateWinningNumbers(dto))
                    .withMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("당첨 번호 리스트가 비어 있음")
        void validateWinningNumbers_EmptyList() {
            List<Integer> numbers = Collections.emptyList(); // 비어 있는 리스트
            WinningNumbersDto dto = WinningNumbersDto.from(numbers);
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.validateWinningNumbers(dto))
                    .withMessageContaining(ERROR_MESSAGE);
        }
    }

    @Nested
    @DisplayName("보너스 번호 검증")
    class BonusNumberValidationTests {

        @Test
        @DisplayName("보너스 번호가 당첨 번호와 중복")
        void validateBonusNumber_DuplicateWithWinningNumber() {
            List<Integer> winningNumbers = Arrays.asList(1, 10, 20, 30, 40, 45);
            WinningNumbersDto winningNumbersDto = WinningNumbersDto.from(winningNumbers);
            BonusNumberDto bonusNumberDto = BonusNumberDto.from(45); // 당첨 번호에 있는 값

            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.validateBonusNumber(winningNumbersDto, bonusNumberDto))
                    .withMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("보너스 번호 범위 밖의 값")
        void validateBonusNumber_OutOfRange() {
            List<Integer> winningNumbers = Arrays.asList(1, 10, 20, 30, 40, 45);
            WinningNumbersDto winningNumbersDto = WinningNumbersDto.from(winningNumbers);
            BonusNumberDto bonusNumberDto = BonusNumberDto.from(46); // LottoConfig 범위 밖의 값

            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.validateBonusNumber(winningNumbersDto, bonusNumberDto))
                    .withMessageContaining(ERROR_MESSAGE);
        }
    }

    @Nested
    @DisplayName("숫자 리스트 크기 검증")
    class NumberListSizeValidationTests {

        private static final int SIZE = LottoConfig.LOTTO_NUMBER_COUNT.getValue();
        @Test
        @DisplayName("리스트 크기가 유효함")
        void validateNumbersSize_ValidSize() {
            List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40, 45);
            Validator.validateNumbersSize(numbers, SIZE);
            assertThat(numbers).doesNotHaveDuplicates();
        }

        @Test
        @DisplayName("리스트 크기가 작음")
        void validateNumbersSize_InvalidSize_ThanSmall() {
            List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40);
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.validateNumbersSize(numbers, SIZE))
                    .withMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("리스트 크기가 큼")
        void validateNumbersSize_InvalidSize_ThanBig() {
            List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40, 44, 45);
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Validator.validateNumbersSize(numbers, SIZE))
                    .withMessageContaining(ERROR_MESSAGE);
        }
    }
}