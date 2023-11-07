package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import lotto.domain.service.LottoService;
import lotto.global.utils.generator.IntendedNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @DisplayName("로또 번호 생성 시")
    @Nested
    class GenerateLottoNumbersTest {

        private static final int PURCHASE_COUNT = 1;

        @DisplayName("[1, 45]범위의 중복없는 6개의 정수가 생성되어야 한다.")
        @Test
        void should_generateValidNumbers_when_generateLottoNumbers() {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

            LottoResultManager lottoResultManager =
                    lottoService.generateLottoNumbers(new IntendedNumbersGenerator(numbers), PURCHASE_COUNT);

            assertThat(lottoResultManager.getLottoResults().get(0).getLottoNumbers().getNumbers())
                    .isSortedAccordingTo(Comparator.naturalOrder());
            assertThat(lottoResultManager.getLottoResults().get(0).getLottoNumbers().getNumbers())
                    .containsExactly(1, 2, 3, 4, 5, 6);
        }

        @DisplayName("중복있는 숫자가 들어가면 실패한다.")
        @Test
        void should_fail_when_isDuplicateNumbers() {
            List<Integer> numbers = List.of(1, 1, 2, 3, 4, 5);

            assertThatThrownBy(
                    () -> lottoService.generateLottoNumbers(new IntendedNumbersGenerator(numbers), PURCHASE_COUNT))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("1미만의 숫자가 들어가면 실패한다.")
        @Test
        void should_fail_when_hasLessThan1() {
            List<Integer> numbers = List.of(-1, 1, 2, 3, 4, 5);

            assertThatThrownBy(
                    () -> lottoService.generateLottoNumbers(new IntendedNumbersGenerator(numbers), PURCHASE_COUNT))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("45초과의 숫자가 들어가면 실패한다.")
        @Test
        void should_fail_when_hasGreaterThan45() {
            List<Integer> numbers = List.of(46, 1, 2, 3, 4, 5);

            assertThatThrownBy(
                    () -> lottoService.generateLottoNumbers(new IntendedNumbersGenerator(numbers), PURCHASE_COUNT))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("6자리가 아니면 실패한다.")
        @Test
        void should_fail_when_lengthIsNot6() {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

            assertThatThrownBy(
                    () -> lottoService.generateLottoNumbers(new IntendedNumbersGenerator(numbers), PURCHASE_COUNT))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("수익률을 계산할 때")
    @Nested
    class GetRateOfReturnTest {

        public static final long PURCHASE_AMOUNT = 10000L;

        @DisplayName("소수점 둘째자리 수가 4이하이면 내림된다.")
        @Test
        void should_floor_when_2DecimalPlacesLessThan4() {
            long totalWinningMoney = 44L;

            double result = lottoService.getRateOfReturn(PURCHASE_AMOUNT, totalWinningMoney);

            BigDecimal expected = new BigDecimal(result).setScale(1, RoundingMode.DOWN);

            assertThat(result)
                    .isEqualTo(expected.doubleValue());
        }

        @DisplayName("소수점 둘째자리 수가 5이상이면 올림된다.")
        @Test
        void should_floor_when_2DecimalPlacesGreaterThan5() {
            long totalWinningMoney = 45L;

            double result = lottoService.getRateOfReturn(PURCHASE_AMOUNT, totalWinningMoney);

            BigDecimal expected = new BigDecimal(result).setScale(1, RoundingMode.UP);

            assertThat(result)
                    .isEqualTo(expected.doubleValue());
        }
    }
}
