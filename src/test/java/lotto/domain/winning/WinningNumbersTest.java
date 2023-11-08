package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.errorMessage.input.IllegalArgumentAmountException;
import lotto.constant.errorMessage.lotto.LottoExceptionStatus;
import lotto.constant.errorMessage.winning.WinningExceptionStatus;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {

    private static final String PROVIDER_PATH = "lotto.domain.winning.provider.WinningNumbersTestProvider#";

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForBonusNumberIsDuplicatedException")
    @DisplayName("보너스 번호는 당첨 번호와 중복될 수 없다.")
    void lottoOutOfSizeExceptionTest(final List<Integer> numbers, final int bonusNumber) {
        assertThatThrownBy(() -> new WinningNumbers(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentAmountException.class)
                .hasMessageContaining(WinningExceptionStatus.BONUS_NUMBER_IS_DUPLICATED.getMessage());
    }
}
