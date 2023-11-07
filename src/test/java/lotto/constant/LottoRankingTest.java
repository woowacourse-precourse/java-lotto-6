package lotto.constant;

import static lotto.constant.LottoRanking.FIFTH;
import static lotto.constant.LottoRanking.FIRST;
import static lotto.constant.LottoRanking.FOURTH;
import static lotto.constant.LottoRanking.SECOND;
import static lotto.constant.LottoRanking.THIRD;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankingTest {

    @DisplayName("정답 횟수와 보너스번호일치 여부를 이용해서 로또 순위를 판별한다.")
    @MethodSource("generateData")
    @ParameterizedTest
    void convertLottoIntoLottoRanking(int count, boolean isBonusNumberCorrect, LottoRanking expected) {
        // when
        LottoRanking result = LottoRanking.convertLottoIntoLottoRanking(count, isBonusNumberCorrect);
        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(6, false, FIRST),
                Arguments.of(5, true, SECOND),
                Arguments.of(5, false, THIRD),
                Arguments.of(4, false, FOURTH),
                Arguments.of(3, false, FIFTH)
        );
    }
}
