package lotto.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberValidatorTest {
    @DisplayName("로또 구매 금액으로 정상적인 값이 전달 됬을 경우 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000})
    void testVerifyPurchaseAmountSuccess(Integer amount) {
        assertThatCode(() -> {
            NumberValidator.verifyPurchaseAmount(amount);
        }).doesNotThrowAnyException();
    }

    @DisplayName("로또 구매 금액으로 잘못된 값이 전달 됬을 경우 에러가 발생한다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(ints = {-1, 0, 1111, 999999999})
    void testVerifyPurchaseAmountFail(Integer amount) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            NumberValidator.verifyPurchaseAmount(amount);
        });
    }

    @DisplayName("로또 번호가 정상적인 값으로 전달 됬을 경우 에러가 발생하지 않는다.")
    @Test
    void testVerifyLottoNumbersSuccess() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> {
            NumberValidator.verifyLottoNumbers(lottoNumbers);
        }).doesNotThrowAnyException();
    }

    @DisplayName("로또 번호로 null 이 전달 됬을 경우 에러가 발생한다.")
    @ParameterizedTest
    @NullSource
    void testVerifyLottoNumbersNullExceptionCheck(List<Integer> lotto) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            NumberValidator.verifyLottoNumbers(lotto);
        });
    }

    @DisplayName("당첨 번호가 정상적인 값으로 전달 됬을 경우 에러가 발생하지 않는다.")
    @Test
    void testVerifyWinningNumbersSuccess() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> {
            NumberValidator.verifyWinningNumbers(winningNumbers);
        }).doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호로 null 이 전달 됬을 경우 에러가 발생한다.")
    @ParameterizedTest
    @NullSource
    void testVerifyWinningNumbersNullExceptionCheck(List<Integer> winningNumbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            NumberValidator.verifyWinningNumbers(winningNumbers);
        });
    }

    @DisplayName("보너스 번호가 정상적인 값으로 전달 됬을 경우 에러가 발생하지 않는다.")
    @Test
    void testVerifyBonusNumberSuccess() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        assertThatCode(() -> {
            NumberValidator.verifyBonusNumber(winningNumbers, bonusNumber);
        }).doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호로 null 이 전달 됬을 경우 에러가 발생한다.")
    @ParameterizedTest
    @NullSource
    void testVerifyBonusNumberNullExceptionCheck(Integer bonusNumber) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            NumberValidator.verifyBonusNumber(winningNumbers, bonusNumber);
        });
    }
}