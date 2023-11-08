package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.errorMessage.amount.IllegalArgumentAmountException;
import lotto.constant.errorMessage.amount.IllegalStateAmountException;
import lotto.constant.errorMessage.lotto.LottoExceptionStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    private static final String PROVIDER_PATH = "lotto.domain.lotto.provider.LottoTestProvider#";

    private void exceptionVerification(final List<Integer> numbers, final String message) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentAmountException.class)
                .hasMessageContaining(message);
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNumbersDuplicatedException")
    @DisplayName("로또 번호는 중복 값이 존재할 수 없다.")
    void lottoNumbersDuplicatedExceptionTest(final List<Integer> numbers) {
        String message = LottoExceptionStatus.LOTTO_NUMBER_IS_DUPLICATED.getMessage();
        exceptionVerification(numbers, message);
    }
}
