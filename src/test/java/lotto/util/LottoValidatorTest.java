package lotto.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000})
    @DisplayName("유효한 구입금액 유효성 검증")
    void validatePurchaseAmount_유효한_구입금액(Integer input) {
        LottoValidator.validatePurchaseAmount(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {999, 1500, 2001, -1000, 0})
    @DisplayName("유효하지 않은 구입금액 유효성 검증 시 예외 발생")
    void validatePurchaseAmount_유효하지_않은_구입금액(Integer input) {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoValidator.validatePurchaseAmount(input);
        });
    }

    @Test
    @DisplayName("유효한 당첨번호 유효성 검증")
    void validateWinningNumber_유효한_당첨번호() {
        List<Integer> numbers = List.of(35, 1, 4, 24, 40, 17);
        LottoValidator.validateWinningNumber(numbers);
    }

    @Test
    @DisplayName("6개가 아닌 당첨번호 유효성 검증 시 예외 발생")
    void validateWinningNumber_6개가_아닌_당첨번호() {
        List<Integer> numbers = List.of(35, 1, 24, 40, 17);

        assertThrows(IllegalArgumentException.class, () -> {
            LottoValidator.validateWinningNumber(numbers);
        });
    }

    @Test
    @DisplayName("정상범위 밖의 당첨번호 유효성 검증 시 예외 발생")
    void validateWinningNumber_범위_밖_당첨번호() {
        List<Integer> numbers = List.of(35, 1, 4, 24, 46, 17);

        assertThrows(IllegalArgumentException.class, () -> {
            LottoValidator.validateWinningNumber(numbers);
        });
    }

    @Test
    @DisplayName("중복된 당첨번호 유효성 검증 시 예외 발생")
    void validateWinningNumber_중복된_당첨번호() {
        List<Integer> numbers = List.of(35, 1, 4, 24, 40, 24);

        assertThrows(IllegalArgumentException.class, () -> {
            LottoValidator.validateWinningNumber(numbers);
        });
    }

    @Test
    @DisplayName("유효한 보너스 번호 유효성 검증")
    void validateBonusNumber_유효한_보너스_번호() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 15, 24, 30, 48));
        Integer bonus = 13;

        LottoValidator.validateBonusNumber(bonus, winningNumber);
    }

    @Test
    @DisplayName("범위 밖 보너스 번호 유효성 검증 시 예외 발생")
    void validateBonusNumber_범위_밖_보너스_번호() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 15, 24, 30, 48));
        Integer bonus = 46;

        assertThrows(IllegalArgumentException.class, () -> {
            LottoValidator.validateBonusNumber(bonus, winningNumber);
        });
    }

    @Test
    @DisplayName("중복 보너스 번호 유효성 검증 시 예외 발생")
    void validateBonusNumber_중복_보너스_번호() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 15, 24, 30, 48));
        Integer bonus = 24;

        assertThrows(IllegalArgumentException.class, () -> {
            LottoValidator.validateBonusNumber(bonus, winningNumber);
        });
    }
}