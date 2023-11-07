package lotto.domain.lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.domain.lottery.constants.LottoConstraint.LOTTO_PICK_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[Domain Layer] LottoService")
class LottoServiceTest {

    @Nested
    @DisplayName("[generateOrderedLottoNumbers] 정렬된 숫자를 로또 숫자 제약조건에 맞게 뽑습니다.")
    class generateLottoNumber {

        /**
         * generateLottoNumber Condition
         * 1. 중복 불허 (pickUniqueNumbersInRange) - Randoms API에서 처리
         * 2. 오름차순 정렬
         */

        private static boolean isListSorted(List<Integer> list) {
            return IntStream.range(0, list.size() - 1)
                    .allMatch(index -> list.get(index) <= list.get(index + 1));
        }

        @Test
        @DisplayName("[Success] 오름차순 정렬된 숫자 리스트를 정상적으로 리턴합니다.")
        void Should_Success_When_Valid() {
            // given && when
            List<Integer> numbers = LottoService.generateOrderedLottoNumbers();
            // then
            assertThat(numbers).hasSize(LOTTO_PICK_COUNT.getValue());
            assertThat(isListSorted(numbers)).isTrue();
        }
    }

    @Nested
    @DisplayName("[calculateFinalYield] 최종")
    class calculateFinalYield {

        /**
         * generateLottoNumber Condition
         * 1. 중복 불허 (pickUniqueNumbersInRange) - Randoms API에서 처리
         * 2. 오름차순 정렬
         */

        private static boolean isListSorted(List<Integer> list) {
            return IntStream.range(0, list.size() - 1)
                    .allMatch(index -> list.get(index) <= list.get(index + 1));
        }

        @Test
        @DisplayName("[Success] 오름차순 정렬된 숫자 리스트를 정상적으로 리턴합니다.")
        void Should_Success_When_Valid() {
            // given && when
            List<Integer> numbers = LottoService.generateOrderedLottoNumbers();
            // then
            assertThat(numbers).hasSize(LOTTO_PICK_COUNT.getValue());
            assertThat(isListSorted(numbers)).isTrue();
        }
    }
}
