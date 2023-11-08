package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LottosTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Nested
    @DisplayName("Lottos 생성 테스트")
    class From {

        @Test
        @DisplayName("Lottos 생성 성공")
        void createLottosSuccessfully() {
            // 준비
            List<Lotto> lottoList = Arrays.asList(
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
            );

            // 실행 & 검증
            Assertions.assertThatCode(() -> Lottos.from(lottoList))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("Lottos 생성 실패 - null 입력")
        void createLottosWithNull() {
            // 실행
            IllegalArgumentException exception
                    = assertThrows(IllegalArgumentException.class, () -> Lottos.from(null));

            // 검증
            Assertions.assertThat(exception.getMessage()).contains(ERROR_MESSAGE);
        }

        @ParameterizedTest
        @MethodSource("provideLottoListsForEquivalencePartitioning")
        @DisplayName("동치 분할 테스트 - 빈 리스트와 비어있지 않은 리스트")
        void equivalencePartitioningWithLottoLists(List<Lotto> lottos) {
            Assertions.assertThatCode(() -> Lottos.from(lottos)).doesNotThrowAnyException();
        }

        static Stream<List<Lotto>> provideLottoListsForEquivalencePartitioning() {
            return Stream.of(
                    Collections.emptyList(),
                    Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))
            );
        }
    }

    @Nested
    @DisplayName("Lottos 동등성 테스트")
    class LottosEqualityTest {
        @Test
        @DisplayName("동일한 Lottos 인스턴스 비교 - equals & hashCode")
        void testLottosEquality() {
            // 준비
            List<Lotto> lottoList1 = Arrays.asList(
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
            );
            Lottos lottos1 = Lottos.from(lottoList1);

            List<Lotto> lottoList2 = Arrays.asList(
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
            );
            Lottos lottos2 = Lottos.from(lottoList2);

            // 실행
            boolean equalsResult = lottos1.equals(lottos2);
            boolean hashCodeResult = lottos1.hashCode() == lottos2.hashCode();

            // 검증
            Assertions.assertThat(equalsResult).isTrue();
            Assertions.assertThat(hashCodeResult).isTrue();
        }

        @Test
        @DisplayName("같은 인스턴스 비교")
        void testEqualsWithSameInstance() {
            // 준비
            List<Lotto> lottoList = Arrays.asList(
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
            );
            Lottos lottos = Lottos.from(lottoList);

            // 실행
            boolean equalsResult = lottos.equals(lottos);

            // 검증
            Assertions.assertThat(equalsResult).isTrue();
        }

        @Test
        @DisplayName("null 객체와 비교")
        void testEqualsWithNull() {
            // 준비
            List<Lotto> lottoList = Arrays.asList(
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
            );
            Lottos lottos = Lottos.from(lottoList);

            // 실행
            boolean equalsResult = lottos.equals(null);

            // 검증
            Assertions.assertThat(equalsResult).isFalse();
        }

        @Test
        @DisplayName("다른 객체 타입과 비교")
        void testEqualsWithDifferentObjectType() {
            // 준비
            List<Lotto> lottoList = Arrays.asList(
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
            );
            Lottos lottos = Lottos.from(lottoList);
            Object differentTypeObject = new Object();

            // 실행
            boolean equalsResult = lottos.equals(differentTypeObject);

            // 검증
            Assertions.assertThat(equalsResult).isFalse();
        }
    }
}