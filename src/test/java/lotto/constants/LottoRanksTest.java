package lotto.constants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRanksTest {

    @ParameterizedTest
    @DisplayName("일치하는 숫자 개수와 2등 조건 달성 여부로 로또 당첨 등수를 결정")
    @MethodSource("sampleForLottoRank")
    void findRank_test(int sameCount, boolean isSecond, LottoRanks expected) {
        assertThat(LottoRanks.findRank(sameCount, isSecond)).isEqualTo(expected);
    }

    private static Stream<Arguments> sampleForLottoRank() {
        return Stream.of(
                Arguments.of(0, false, LottoRanks.NONE),
                Arguments.of(2, false, LottoRanks.NONE),
                Arguments.of(3, false, LottoRanks.FIFTH),
                Arguments.of(4, false, LottoRanks.FOURTH),
                Arguments.of(5, false, LottoRanks.THIRD),
                Arguments.of(5, true, LottoRanks.SECOND),
                Arguments.of(6, false, LottoRanks.FIRST)
        );
    }
}