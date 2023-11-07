package lotto.domain.lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("[Domain Layer] LottoService")
class LottoServiceTest {

    @Nested
    @DisplayName("[generateLottos] ticketCount에 맞게 List<Lotto>를 생성해 리턴합니다.")
    class generateLottos {

        /**
         * 1. 로또 자릿수 만큼의 랜덤한 중복되지 않는 수 리스트 생성
         * 2. 생성된 리스트를 오름차순 정렬
         * 3. 정렬된 리스트를 Lotto로 객체화
         * 4. Stream으로 ticketCount만큼 순회하며 List<Lotto>로 리턴
         */

        private static boolean isLottoSorted(Lotto lotto) {
            List<Integer> numbers = lotto.getNumbers();

            return IntStream.range(0, numbers.size() - 1)
                    .allMatch(index -> numbers.get(index) <= numbers.get(index + 1));
        }

        @Test
        @DisplayName("[Success] 오름차순 정렬된 숫자 리스트를 정상적으로 리턴합니다.")
        void Should_Success_When_Valid() {
            // given && when
            final int expectTicketCount = 30;
            final List<Lotto> lottoList = LottoService.generateLottos(expectTicketCount);

            final boolean expectTrue = lottoList.stream()
                    .allMatch(generateLottos::isLottoSorted);

            // then
            assertAll(
                    () -> assertThat(lottoList).hasSize(expectTicketCount),
                    () -> assertThat(expectTrue).isTrue()
            );
        }
    }

    @Nested
    @DisplayName("[calculateFinalYield] 수익률을 정상적으로 계산합니다.")
    class calculateFinalYield {

        @Test
        @DisplayName("[Success] 수익률 계산 성공")
        void Should_Success_When_Valid() {
            // given
            final int payment = 300_000;
            final long income = 1_375_265;
            final BigDecimal expected = new BigDecimal("458.4");
            // when
            BigDecimal result = LottoService.calculateFinalYield(payment, income);
            // then
            assertThat(expected).isEqualTo(result);
        }
    }
}
