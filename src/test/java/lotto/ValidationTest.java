package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.util.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    // 입력 받은 로또 번호에 대한 테스트
    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 46);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                Validation.validateLottoNumbers(lottoNumber));
        assertThat(exception.getMessage()).contains(ERROR_MESSAGE);
    }

    // 입력 받은 로또 구입 가격에 대한 테스트
    @DisplayName("로또 구입 가격이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoCostByNotIntegerFormat() {
        String lottoCost = "not number";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                Validation.validatePrice(lottoCost));
        assertThat(exception.getMessage()).contains(ERROR_MESSAGE);
    }

    @DisplayName("입력값에 공백이 포함되어 있을 경우 예외가 발생한다.")
    @Test
    void createLottoCostByContainsSpace() {
        String lottoCost = "1 2";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                Validation.validatePrice(lottoCost));
        assertThat(exception.getMessage()).contains(ERROR_MESSAGE);
    }

    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void createLottoCostByNotDivisibleThousand() {
        String lottoCost = "2500"; // 1000으로 나누어 떨어지지 않음

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                Validation.validatePrice(lottoCost));
        assertThat(exception.getMessage()).contains(ERROR_MESSAGE);
    }

    // 입력 받은 보너스 넘버에 대한 테스트
    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createBonusNumberByNotIntegerFormat() {
        String bonusNumber = "abc";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                Validation.validateBonusNumber(bonusNumber, winningNumbers));
        assertThat(exception.getMessage()).contains(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRangeNumber() {
        String bonusNumber = "46";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                Validation.validateBonusNumber(bonusNumber, winningNumbers));
        assertThat(exception.getMessage()).contains(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedLottoNumber() {
        String bonusNumber = "5"; // 당첨 번호와 중복되는 숫자
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                Validation.validateBonusNumber(bonusNumber, winningNumbers));
        assertThat(exception.getMessage()).contains(ERROR_MESSAGE);
    }
}

