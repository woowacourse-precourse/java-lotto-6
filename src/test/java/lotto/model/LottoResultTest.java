package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @ParameterizedTest
    @DisplayName("보너스번호와 로또가 몇개 맞는지 테스트 ")
    @MethodSource("providedeterminePrizeList")
    void determinePrizeTest(Integer matchedWinningNumberCount, Boolean matchedBonusNumber, LottoResult expectedMatch) {

        assertThat(LottoResult.determinePrize(matchedWinningNumberCount,matchedBonusNumber)).isEqualTo(expectedMatch);

    }
    static Stream<Arguments> providedeterminePrizeList() {
        return Stream.of(
                Arguments.of(0,false,LottoResult.NO_PRIZE),
                Arguments.of(0,true,LottoResult.NO_PRIZE),
                Arguments.of(1,false,LottoResult.NO_PRIZE),
                Arguments.of(1,true,LottoResult.NO_PRIZE),
                Arguments.of(2,false,LottoResult.NO_PRIZE),
                Arguments.of(2,true,LottoResult.NO_PRIZE),
                Arguments.of(3,false,LottoResult.FIFTH_PRIZE),
                Arguments.of(3,true,LottoResult.FIFTH_PRIZE),
                Arguments.of(4,false,LottoResult.FOURTH_PRIZE),
                Arguments.of(4,true,LottoResult.FOURTH_PRIZE),
                Arguments.of(5,false,LottoResult.THIRD_PRIZE),
                Arguments.of(5,true,LottoResult.SECOND_PRIZE),
                Arguments.of(6,false,LottoResult.FIRST_PRIZE)
        );
    }
}
