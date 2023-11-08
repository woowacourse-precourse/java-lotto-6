package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {

    @Test
    @DisplayName("구매 금액 입력 예외 테스트")
    void validInputPurchaseAmountTest() {
        assertThat(InputValidator.validInputPurchaseAmount("8000")).isEqualTo("8000");
        assertThatThrownBy(() -> InputValidator.validInputPurchaseAmount("100")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 숫자 입력 예외 테스트")
    void validInputWinningNumbersTest() {
        // 올바른 입력
        assertThat(InputValidator.validInputWinningNumbers("1,2,3,4,5,6")).isEqualTo("1,2,3,4,5,6");
        // 중복된 입력
        assertThatThrownBy(() -> InputValidator.validInputWinningNumbers("1,2,3,4,5,5")).isInstanceOf(IllegalArgumentException.class);
        // 숫자가 아닌 입력
        assertThatThrownBy(() -> InputValidator.validInputWinningNumbers("1,[")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자 입력 예외 테스트")
    void validInputBonusTest() {
        String input = "1,2,3,4,5,6";
        List<Integer> winningNumbers = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();

        // 정상 입력
        assertThat(InputValidator.validInputBonus(winningNumbers, "45")).isEqualTo("45");
        // 범위 초과
        assertThatThrownBy(() -> InputValidator.validInputBonus(winningNumbers, "46")).isInstanceOf(IllegalArgumentException.class);
        // 개수 초과
        assertThatThrownBy(() -> InputValidator.validInputBonus(winningNumbers, "1,45")).isInstanceOf(IllegalArgumentException.class);
        // 숫자가 아닌 문자 입력
        assertThatThrownBy(() -> InputValidator.validInputBonus(winningNumbers, "[1,45")).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("숫자형식 테스트")
    void isNumberFormatTest() {
        // 정상 입력
        assertThat(InputValidator.isNumberFormat("5600")).isEqualTo(true);
        // 문자 입력
        assertThat(InputValidator.isNumberFormat("5600,1000")).isEqualTo(false);
        // 공백 입력
        assertThat(InputValidator.isNumberFormat("")).isEqualTo(false);
    }

    @Test
    @DisplayName("범위 테스트")
    void isRangeTest() {
        // 최소 범위
        assertThat(InputValidator.isRange("1")).isEqualTo(true);
        // 최대 범위
        assertThat(InputValidator.isRange("45")).isEqualTo(true);
        // 최대 범위 초과
        assertThat(InputValidator.isRange("46")).isEqualTo(false);
        // 최소 범위 미만
        assertThat(InputValidator.isRange("0")).isEqualTo(false);
    }

    @Test
    @DisplayName("구매 금액 단위 테스트")
    void isUnitTest() {
        assertThat(InputValidator.isUnit("1000")).isEqualTo(true);
        assertThat(InputValidator.isUnit("00")).isEqualTo(false);
        assertThat(InputValidator.isUnit("1100")).isEqualTo(false);
    }

    @Test
    @DisplayName("당첨 번호 입력 개수 테스트")
    void isSixNumberTest() {
        assertThat(InputValidator.isSixNumber("1,2,3,4,5,6")).isEqualTo(true);
        assertThat(InputValidator.isSixNumber("1,2,3,4,5")).isEqualTo(false);
    }

    @Test
    @DisplayName("당첨 번호 범위 테스트")
    void isWinningRangeTest() {
        assertThat(InputValidator.isWinningRange("1,2,3,4,5,45")).isEqualTo(true);
        assertThat(InputValidator.isWinningRange("l,2,3,4,5,46")).isEqualTo(false);
    }
}