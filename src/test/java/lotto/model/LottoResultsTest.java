package lotto.model;

import static org.assertj.core.api.Assertions.*;

import lotto.config.Rank;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.*;
import java.util.stream.*;

class LottoResultsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Nested
    @DisplayName("from 테스트")
    class From {

        @Test
        @DisplayName("정상적인 결과 맵으로부터 LottoResults를 생성한다.")
        void createLottoResultsWithValidMap() {
            // 준비
            Map<Rank, Long> results = new EnumMap<>(Rank.class);
            results.put(Rank.FIRST, 1L);

            // 실행
            LottoResults lottoResults = LottoResults.from(results);

            // 검증
            assertThat(lottoResults.getResults()).containsExactlyInAnyOrderEntriesOf(results);
        }

        @ParameterizedTest
        @MethodSource("provideInvalidMaps")
        @DisplayName("잘못된 결과 맵으로부터 LottoResults를 생성하려 하면 예외를 발생시킨다.")
        void createLottoResultsWithInvalidMap(Map<Rank, Long> results,
                                              Class<? extends Throwable> expectedException,
                                              String expectedMessage) {
            // 실행
            Throwable thrown = catchThrowable(() -> LottoResults.from(results));

            // 검증
            assertThat(thrown).isInstanceOf(expectedException).hasMessageContaining(expectedMessage);
        }

        private static Stream<Arguments> provideInvalidMaps() {
            return Stream.of(
                    Arguments.of(null, IllegalArgumentException.class, ERROR_MESSAGE)
            );
        }
    }

    @Nested
    @DisplayName("calculateTotalPrize 테스트")
    class CalculateTotalPrize {

        @Test
        @DisplayName("각 등수별 당첨 금액을 올바르게 계산한다.")
        void calculateTotalPrizeCorrectly() {
            // 준비
            Map<Rank, Long> results = new EnumMap<>(Rank.class);
            results.put(Rank.FIRST, 1L); // 2,000,000,000 * 1
            results.put(Rank.SECOND, 2L); // 30,000,000 * 2
            results.put(Rank.THIRD, 3L); // 1,500,000 * 3
            LottoResults lottoResults = LottoResults.from(results);

            // 실행
            long totalPrize = lottoResults.calculateTotalPrize();

            // 검증
            long expectedPrize = 2_000_000_000L * 1 + 30_000_000L * 2 + 1_500_000L * 3;
            assertThat(totalPrize).isEqualTo(expectedPrize);
        }

        @Test
        @DisplayName("등수가 없는 경우의 당첨 금액을 계산에서 제외한다.")
        void excludeNoneRankInTotalPrizeCalculation() {
            // 준비
            Map<Rank, Long> results = new EnumMap<>(Rank.class);
            results.put(Rank.NONE, 10L); // 당첨금 0원
            results.put(Rank.FOURTH, 2L); // 당첨금 있음
            LottoResults lottoResults = LottoResults.from(results);

            // 실행
            long totalPrize = lottoResults.calculateTotalPrize();

            // 검증
            assertThat(totalPrize).isEqualTo(Rank.FOURTH.getPrizeMoney() * 2);
        }
    }

    @Nested
    @DisplayName("LottoResults 동등성 테스트")
    class LottoResultsEqualityTests {

        @Test
        @DisplayName("동일한 결과 인스턴스 비교 - equals & hashCode")
        void testLottoResultsEquality() {
            Map<Rank, Long> results1 = new EnumMap<>(Rank.class);
            results1.put(Rank.FIRST, 1L);

            Map<Rank, Long> results2 = new EnumMap<>(Rank.class);
            results2.put(Rank.FIRST, 1L);

            LottoResults lottoResults1 = LottoResults.from(results1);
            LottoResults lottoResults2 = LottoResults.from(results2);

            assertThat(lottoResults1).isEqualTo(lottoResults2);
            assertThat(lottoResults1.hashCode()).isEqualTo(lottoResults2.hashCode());
        }

        @Test
        @DisplayName("동일하지 않은 결과 인스턴스 비교 - equals & hashCode")
        void testLottoResultsInequality() {
            Map<Rank, Long> results1 = new EnumMap<>(Rank.class);
            results1.put(Rank.FIRST, 1L);

            Map<Rank, Long> results2 = new EnumMap<>(Rank.class);
            results2.put(Rank.SECOND, 1L);

            LottoResults lottoResults1 = LottoResults.from(results1);
            LottoResults lottoResults2 = LottoResults.from(results2);

            assertThat(lottoResults1).isNotEqualTo(lottoResults2);
        }

        @Test
        @DisplayName("동일한 LottoResults 인스턴스 비교 - equals & hashCode")
        void shouldBeEqualIfLottoResultsAreSameInstance() {
            Map<Rank, Long> results = new EnumMap<>(Rank.class);
            results.put(Rank.FIRST, 1L);

            LottoResults lottoResults = LottoResults.from(results);

            assertThat(lottoResults).isEqualTo(lottoResults);
            assertThat(lottoResults.hashCode()).isEqualTo(lottoResults.hashCode());
        }

        @Test
        @DisplayName("null과 비교 - equals")
        void testEqualsAgainstNull() {
            Map<Rank, Long> results = new EnumMap<>(Rank.class);
            results.put(Rank.FIRST, 1L);
            LottoResults lottoResults = LottoResults.from(results);

            assertThat(lottoResults.equals(null)).isFalse();
        }

        @Test
        @DisplayName("다른 클래스 객체와 비교 - equals")
        void testEqualsAgainstDifferentClassObject() {
            Map<Rank, Long> results = new EnumMap<>(Rank.class);
            results.put(Rank.FIRST, 1L);
            LottoResults lottoResults = LottoResults.from(results);

            assertThat(lottoResults.equals(new Object())).isFalse();
        }
    }
}