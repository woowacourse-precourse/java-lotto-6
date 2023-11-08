package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayLottoTest {

    PlayLotto playLotto = new PlayLotto();

    @ParameterizedTest
    @MethodSource("generateMatchedNumberData")
    void 맞은_갯수를_알아낸다(List<Integer> userLottoNumbers, List<Integer> lottoNumbers, int expected) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = playLotto.getMatchedNumberCnt(userLottoNumbers, lottoNumbers);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("generateRankData")
    void 맞은_갯수에_따른_등수를_알아낸다(int matchedNumberCnt, boolean hasBonusNumber, Rank rank) {
        assertThat(rank.matchedCnt).isEqualTo(matchedNumberCnt);
        assertThat(rank.hasBonusNumber).isEqualTo(hasBonusNumber);
    }

    static Stream<Arguments> generateMatchedNumberData(){
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), Arrays.asList(1, 2, 3, 4, 5, 6), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 7, 8), Arrays.asList(1, 2, 3, 4, 5, 6), 4),
                Arguments.of(Arrays.asList(1, 2, 3, 7, 8, 9), Arrays.asList(1, 2, 3, 4, 5, 6), 3),
                Arguments.of(Arrays.asList(1, 2, 7, 8, 9, 10), Arrays.asList(1, 2, 3, 4, 5, 6), 2),
                Arguments.of(Arrays.asList(1, 7, 8, 9, 10, 11), Arrays.asList(1, 2, 3, 4, 5, 6), 1),
                Arguments.of(Arrays.asList(7, 8, 9, 10, 11, 12), Arrays.asList(1, 2, 3, 4, 5, 6), 0)
        );
    }

    static Stream<Arguments> generateRankData(){
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, false, Rank.FIFTH)
        );
    }
}