package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionTest {
    @DisplayName("문자 또는 특수문자 등 숫자가 아닌 입력인 경우 예외가 발생한다.")
    @Test
    void throwExceptionIfNotNumber() {
        String inputData = "abc";
        assertThatThrownBy(() -> Exception.notNumber(inputData))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 로또 구입 금액이 1,000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void throwExceptionIfNotThousandWon() {
        int purchaseAmount = 1500;
        assertThatThrownBy(() -> Exception.notThousandWon(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 숫자 개수가 6개가 아닌 경우 예외가 발생한다.")
    @Test
    void throwExceptionIfNotMatchCount() {
        int inputSize = 7;
        assertThatThrownBy(() -> Exception.overLimitCount(inputSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 숫자 범위 1~45를 초과한 경우 예외가 발생한다.")
    @Test
    void throwExceptionIfOverLimitNumberRange() {
        int number = 46;
        assertThatThrownBy(() -> Exception.overLimitNumberRange(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복된 경우 예외가 발생한다.")
    @Test
    void throwExceptionIfDuplicateWinNumbers() {
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 1);
        assertThatThrownBy(() -> Exception.duplicateWinNumbers(winNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복된 경우 예외가 발생한다.")
    @Test
    void throwExceptionIfDuplicateWinNumbersAndBonusNumber() {
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        assertThatThrownBy(() -> Exception.duplicateBonusNumber(winNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
