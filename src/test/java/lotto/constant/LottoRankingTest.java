package lotto.constant;

import static lotto.constant.LottoRanking.FIFTH;
import static lotto.constant.LottoRanking.FIRST;
import static lotto.constant.LottoRanking.FOURTH;
import static lotto.constant.LottoRanking.SECOND;
import static lotto.constant.LottoRanking.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankingTest {

    @DisplayName("정답 횟수와 보너스번호일치 여부를 이용해서 로또 순위를 판별한다.")
    @MethodSource("generateLottoAndRanking")
    @ParameterizedTest
    void convertLottoIntoLottoRanking(int count, boolean isBonusNumberCorrect, LottoRanking expected) {
        // when
        LottoRanking result = LottoRanking.convertLottoIntoLottoRanking(count, isBonusNumberCorrect);
        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> generateLottoAndRanking() {
        return Stream.of(
                Arguments.of(6, false, FIRST),
                Arguments.of(5, true, SECOND),
                Arguments.of(5, false, THIRD),
                Arguments.of(4, false, FOURTH),
                Arguments.of(3, false, FIFTH)
        );
    }

    @DisplayName("로또 순위들을 키, 0을 value로 갖는 map이 생성된다.")
    @MethodSource("generateKeyAndValue")
    @ParameterizedTest
    void convertValuesIntoCounters(LottoRanking key, int value) {
        // when
        Map<LottoRanking, Integer> result = LottoRanking.convertValuesIntoCounters();

        // then
        assertThat(result).containsEntry(key, value);
    }

    static Stream<Arguments> generateKeyAndValue() {
        return Stream.of(
                Arguments.of(FIRST, 0),
                Arguments.of(SECOND, 0),
                Arguments.of(THIRD, 0),
                Arguments.of(FOURTH, 0),
                Arguments.of(FIFTH, 0)
        );
    }
}
