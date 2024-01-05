package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.errorMessage.exception.CustomIllegalArgumentException;
import lotto.constant.errorMessage.exception.CustomIllegalStateAmountException;
import lotto.constant.errorMessage.winning.WinningExceptionStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {

    private static final String PROVIDER_PATH = "lotto.domain.winning.provider.WinningNumbersTestProvider#";

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForBonusNumberIsOutOfRangeException")
    @DisplayName("보너스 번호는 1부터 45 사이의 숫자로 구성되어야 한다.")
    void bonusNumberIsOutOfRangeExceptionTest(final List<Integer> numbers, final int bonusNumber) {
        assertThatThrownBy(() -> new WinningNumbers(numbers, bonusNumber))
                .isInstanceOf(CustomIllegalStateAmountException.class)
                .hasMessageContaining(WinningExceptionStatus.BONUS_NUMBER_IS_OUT_OF_RANGE.getMessage());
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForBonusNumberIsDuplicatedException")
    @DisplayName("보너스 번호는 당첨 번호와 중복될 수 없다.")
    void bonusNumberIsDuplicatedExceptionTest(final List<Integer> numbers, final int bonusNumber) {
        assertThatThrownBy(() -> new WinningNumbers(numbers, bonusNumber))
                .isInstanceOf(CustomIllegalArgumentException.class)
                .hasMessageContaining(WinningExceptionStatus.BONUS_NUMBER_IS_DUPLICATED.getMessage());
    }
}
