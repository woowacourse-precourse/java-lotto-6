package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constant.errorMessage.exception.CustomIllegalArgumentException;
import lotto.constant.errorMessage.lotto.LottoExceptionStatus;
import lotto.domain.rank.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    private static final String PROVIDER_PATH = "lotto.domain.lotto.provider.LottoTestProvider#";

    private void exceptionVerification(final List<Integer> numbers, final String message) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(CustomIllegalArgumentException.class)
                .hasMessageContaining(message);
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNumbersOutOfSizeExceptionTest")
    @DisplayName("로또 번호는 6개의 숫자로 구성되어야 한다.")
    void lottoOutOfSizeExceptionTest(final List<Integer> numbers) {
        String message = LottoExceptionStatus.LOTTO_NUMBER_IS_OUT_OF_SIZE.getMessage();
        exceptionVerification(numbers, message);
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNumbersOutOfRangeExceptionTest")
    @DisplayName("로또 번호는 1부터 45 사이의 숫자로 구성되어야 한다.")
    void lottoOutOfRangeExceptionTest(final List<Integer> numbers) {
        String message = LottoExceptionStatus.LOTTO_NUMBER_IS_OUT_OF_RANGE.getMessage();
        exceptionVerification(numbers, message);
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNumbersDuplicatedExceptionTest")
    @DisplayName("로또 번호는 중복 값이 존재할 수 없다.")
    void lottoNumbersDuplicatedExceptionTest(final List<Integer> numbers) {
        String message = LottoExceptionStatus.LOTTO_NUMBER_IS_DUPLICATED.getMessage();
        exceptionVerification(numbers, message);
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNumbersContainsTargetNumberTrueTest")
    @DisplayName("로또 번호는 목표값을 가지고 있으면 참을 반환한다.")
    void lottoNumbersContainsTrueTest(final List<Integer> numbers, final int targetNumber) {
        final Lotto lotto = new Lotto(numbers);
        assertThat(lotto.isContains(targetNumber)).isTrue();
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNumbersContainsTargetNumberFalseTest")
    @DisplayName("로또 번호는 목표값을 가지고 있지 않으면 거짓을 반환한다.")
    void lottoNumbersContainsFalseTest(final List<Integer> numbers, final int targetNumber) {
        final Lotto lotto = new Lotto(numbers);
        assertThat(lotto.isContains(targetNumber)).isFalse();
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNumbersMatchedCountTest")
    @DisplayName("당첨 번호와 목표값의 일치 개수는 같아야 한다.")
    void lottoNumbersMatchedCountTest(final List<Integer> numbers,
                                      final List<Integer> winningNumbers, final int matchCount) {
        final Lotto lotto = new Lotto(numbers);
        final Lotto winningLotto = new Lotto(winningNumbers);
        final List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        assertThat(lotto.matchedCount(winningLottoNumbers)).isEqualTo(matchCount);
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForCalculateRankTest")
    @DisplayName("당첨 결과는 목표값과 일치해야 한다.")
    void calculateRankTest(final List<Integer> numbers,
                           final List<Integer> winningNumbers, final int bonusNumber, final Rank expectedRank) {
        final Lotto lotto = new Lotto(numbers);
        final Lotto winningLotto = new Lotto(winningNumbers);
        final Rank rank = lotto.calculateRank(winningLotto, bonusNumber).orElse(null);
        assertThat(rank).isEqualTo(expectedRank);
    }
}
