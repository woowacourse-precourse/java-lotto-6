package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.constants.LottoRanks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ComparingTest {

    // Comparing 생성자의 첫번째, 두번째 인자는 각각 당첨번호와 보너스번호
    private final Comparing sample = new Comparing(new Lotto(List.of(8, 21, 23, 41, 42, 43)), 30);

    @ParameterizedTest
    @DisplayName("현재 로또와 당첨번호 간 일치하는 숫자의 개수를 산출")
    @MethodSource("sampleEachLottoAndCount")
    void countSameNumber_test(List<Integer> inputLotto, int expected) {
        assertThat(sample.countSameNumber(inputLotto)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("발행한 로또에 보너스 번호가 포함될 떄, 현재 로또가 2등이면 true, 그 외의 등수이면 false를 반환")
    @MethodSource("sampleEachLottoAndBoolean")
    void isLottoRankSecond_test(List<Integer> eachLotto, boolean expected) {
        int sameCount = sample.countSameNumber(eachLotto);
        assertThat(sample.isLottoRankSecond(sameCount, eachLotto)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("각 등수별 당첨된 로또 개수 산출")
    @MethodSource("sampleAllLottoAndResult")
    void getResult_test(List<List<Integer>> inputAllLotto, Map<LottoRanks, Integer> expected) {
        Map<LottoRanks, Integer> result = sample.getResult(inputAllLotto);
        assertThat(result.entrySet()).isEqualTo(expected.entrySet());
    }

    private static Stream<Arguments> sampleEachLottoAndCount() { // 발행받은 로또 번호 & 일치하는 번호 개수
        return Stream.of(
                Arguments.of(List.of(5, 19, 22, 41, 42, 43), 3),
                Arguments.of(List.of(6, 20, 23, 41, 42, 43), 4),
                Arguments.of(List.of(7, 21, 23, 41, 42, 43), 5),
                Arguments.of(List.of(8, 21, 23, 41, 42, 43), 6)
        );
    }

    private static Stream<Arguments> sampleEachLottoAndBoolean() { // 발행받은 로또 개수 & 2등당첨 여부
        return Stream.of(
                Arguments.of(List.of(3, 18, 20, 30, 39, 40), false),
                Arguments.of(List.of(5, 19, 22, 41, 42, 43), false),
                Arguments.of(List.of(6, 20, 23, 30, 42, 43), false),
                Arguments.of(List.of(7, 21, 23, 41, 42, 43), false),
                Arguments.of(List.of(8, 21, 23, 30, 41, 42), true),
                Arguments.of(List.of(8, 21, 23, 41, 42, 43), false)
        );
    }

    private static Stream<Arguments> sampleAllLottoAndResult() {
        List<List<Integer>> sampleAllLotto = List.of(List.of(7, 21, 23, 41, 42, 43), List.of(8, 21, 23, 30, 41, 42));
        Map<LottoRanks, Integer> expected = Map.of(
                LottoRanks.NONE, 0, LottoRanks.FIFTH, 0, LottoRanks.FOURTH, 0,
                LottoRanks.THIRD, 1, LottoRanks.SECOND, 1, LottoRanks.FIRST, 0
        );
        return Stream.of(Arguments.of(sampleAllLotto, expected));
    }
}