package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.config.LottoConfig;
import lotto.dto.request.BonusNumberDto;
import lotto.dto.request.WinningNumbersDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ValidatorTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    @Test
    @DisplayName("정수로 변환: 유효한 숫자 문자열")
    void validateAndParseInteger_Valid() {
        String input = "100";
        int result = Validator.validateAndParseInteger(input);
        assertThat(result).isEqualTo(100);
    }

    @Test
    @DisplayName("정수로 변환: 숫자가 아닌 문자열")
    void validateAndParseInteger_Invalid() {
        String input = "abc";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Validator.validateAndParseInteger(input))
                .withMessageContaining(ERROR_MESSAGE);
    }

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

    @Test
    @DisplayName("숫자 범위 검증: 유효 범위 내")
    void validateNumberInRange_Valid() {
        Validator.validateNumberInRange(10); // LottoConfig 범위 내 값
        assertThat(10)
                .isBetween(LottoConfig.START_OF_LOTTO_NUMBER.getValue(), LottoConfig.END_OF_LOTTO_NUMBER.getValue());
    }

    @Test
    @DisplayName("숫자 범위 검증: 유효 범위 외")
    void validateNumberInRange_Invalid() {
        int invalidNumber = LottoConfig.END_OF_LOTTO_NUMBER.getValue() + 1;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Validator.validateNumberInRange(invalidNumber))
                .withMessageContaining(ERROR_MESSAGE);;
    }

    @Test
    @DisplayName("숫자 리스트 범위 검증: 모두 유효 범위 내")
    void validateNumbersInRange_AllValid() {
        List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40, 45); // LottoConfig 범위 내 값들
        Validator.validateNumbersInRange(numbers);
        assertThat(numbers).allMatch(num ->
                num >= LottoConfig.START_OF_LOTTO_NUMBER.getValue() &&
                        num <= LottoConfig.END_OF_LOTTO_NUMBER.getValue());
    }

    @Test
    @DisplayName("숫자 리스트 범위 검증: 유효 범위를 벗어난 숫자 포함")
    void validateNumbersInRange_ContainsInvalid() {
        List<Integer> numbers = Arrays.asList(0, 10, 20, 30, 40, 46); // 0과 46은 LottoConfig 범위 외
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Validator.validateNumbersInRange(numbers))
                .withMessageContaining(ERROR_MESSAGE);;
    }

    @Test
    @DisplayName("숫자 리스트 중복 검증: 중복 없음")
    void validateUniqueNumbers_NoDuplicates() {
        List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40, 45);
        Validator.validateUniqueNumbers(numbers);
        assertThat(numbers).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("숫자 리스트 중복 검증: 중복 포함")
    void validateUniqueNumbers_WithDuplicates() {
        List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40, 40);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Validator.validateUniqueNumbers(numbers))
                .withMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("당첨 번호 검증: 유효한 당첨 번호")
    void validateWinningNumbers_Valid() {
        List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40, 45);
        WinningNumbersDto dto = WinningNumbersDto.from(numbers);
        Validator.validateWinningNumbers(dto);
    }

    @Test
    @DisplayName("당첨 번호 검증: 당첨 번호의 크기가 잘못됨")
    void validateWinningNumbers_InvalidSize() {
        List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40); // 6개가 아님
        WinningNumbersDto dto = WinningNumbersDto.from(numbers);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Validator.validateWinningNumbers(dto))
                .withMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("보너스 번호 검증: 보너스 번호가 당첨 번호와 중복")
    void validateBonusNumber_DuplicateWithWinningNumber() {
        List<Integer> winningNumbers = Arrays.asList(1, 10, 20, 30, 40, 45);
        WinningNumbersDto winningNumbersDto = WinningNumbersDto.from(winningNumbers);
        BonusNumberDto bonusNumberDto = BonusNumberDto.from(45); // 당첨 번호에 있는 값

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Validator.validateBonusNumber(winningNumbersDto, bonusNumberDto))
                .withMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("보너스 번호 검증: 보너스 번호 범위 밖의 값")
    void validateBonusNumber_OutOfRange() {
        List<Integer> winningNumbers = Arrays.asList(1, 10, 20, 30, 40, 45);
        WinningNumbersDto winningNumbersDto = WinningNumbersDto.from(winningNumbers);
        BonusNumberDto bonusNumberDto = BonusNumberDto.from(46); // LottoConfig 범위 밖의 값

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Validator.validateBonusNumber(winningNumbersDto, bonusNumberDto))
                .withMessageContaining(ERROR_MESSAGE);
    }
}