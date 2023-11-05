package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @MethodSource("provideOutOfRangeNumbers")
    @DisplayName("로또 번호 예외 처리: 1 ~ 45 범위를 벗어난 경우")
    void givenOutOfRangeNumbers_whenCreateLotto_then(List<Integer> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers))
                .withMessageStartingWith("[ERROR]")
                .withMessageContaining("로또 번호는 1 ~ 45 숫자만 가능합니다.");
    }

    private static Stream<Arguments> provideOutOfRangeNumbers() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 2, 3, 4, 45)),
                Arguments.of(List.of(1, 2, 3, 4, 45, 46))
        );
    }

    @Test
    @DisplayName("로또 생성 성공")
    void givenNumbers_whenCreateLotto_thenNoException() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatNoException()
                .isThrownBy(() -> new Lotto(numbers));
    }

    @ParameterizedTest(name = "입력값 : {0}, 기대값 : {1}")
    @MethodSource("provideDataForCompare")
    @DisplayName("두 개의 로또를 비교해 매칭된 번호 개수를 알려준다")
    void givenTwoLotto_whenCompare_thenReturnMatchingCount(List<Integer> numbers, int expected) {
        // given
        Lotto fixedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);

        // when
        int result = fixedLotto.compare(lotto);

        // then
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideDataForCompare() {
        return Stream.of(
                Arguments.of(List.of(1, 7, 8, 9, 10, 11), 1),
                Arguments.of(List.of(1, 2, 8, 9, 10, 11), 2),
                Arguments.of(List.of(1, 2, 3, 9, 10, 11), 3),
                Arguments.of(List.of(1, 2, 3, 4, 10, 11), 4),
                Arguments.of(List.of(1, 2, 3, 4, 5, 11), 5),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "7:false"}, delimiter = ':')
    @DisplayName("로또가 해당 번호를 갖고 있는지 알려준다")
    void givenLottoAndNumber_whenHasNumber_thenReturnTrueOrFalse(int number, boolean expected) {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean result = lotto.hasNumber(number);

        // then
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "입력값 : {0}, 기대 순위 : {1}, 기대 개수 : {2}")
    @MethodSource("provideDataForGetRankResult")
    @DisplayName("로또마다 순위를 구해 결과를 반환: key(순위)-value(개수)")
    void givenData_whenGetRankResult_thenReturnResult(List<Integer> numbers, Rank expectedRank, int expectedCount) {
        // given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lottos userLottos = new Lottos(List.of(new Lotto(numbers)));

        // when
        EnumMap<Rank, Integer> result = userLottos.getRankResult(winningLotto);

        // then
        assertThat(result.containsKey(expectedRank)).isTrue();
        assertEquals(expectedCount, result.get(expectedRank));
    }

    static Stream<Arguments> provideDataForGetRankResult() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), Rank.FIRST, 1),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), Rank.SECOND, 1),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), Rank.THIRD, 1),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), Rank.FOURTH, 1),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), Rank.FIFTH, 1),
                Arguments.of(List.of(1, 2, 7, 8, 9, 10), Rank.UNRANKED, 1)
        );
    }

    @ParameterizedTest(name = "입력값 : {0}, 기대값 : {1}")
    @MethodSource("provideDataForCalculateTotalReward")
    @DisplayName("총 당첨 금액 계산")
    void givenData_whenCalculateTotalReward_thenReturnCorrectReward(List<Lotto> lottos, long expected) {
        // given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lottos userLottos = new Lottos(lottos);

        // when
        long result = userLottos.calculateTotalReward(userLottos.getRankResult(winningLotto));

        // then
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideDataForCalculateTotalReward() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 7))
                        ), 4_030_000_000L
                ),
                Arguments.of(
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                                new Lotto(List.of(1, 2, 3, 7, 8, 9))
                        ), 1_605_000L
                )
        );
    }

}
