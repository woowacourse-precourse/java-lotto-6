package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComparatorTest {
    @DisplayName("1등부터 5등까지 당첨번호와 비교하여 추첨할 수 있다.")
    @ParameterizedTest
    @MethodSource("provideLottoNumbersAndRanks")
    void isHasBonusNumber(Lotto userLotto, LottoRank expectedRank) {
        //given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(2, 5, 6, 7, 14, 31)), 8);
        Comparator comparator = new Comparator(winningLotto);

        //when
        LottoRank lottoRank = comparator.compareWithWinningLotto(userLotto);

        //then
        assertThat(lottoRank).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> provideLottoNumbersAndRanks() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(2, 5, 6, 32, 33, 34)), LottoRank.FIFTH),
                Arguments.of(new Lotto(List.of(2, 5, 6, 7, 33, 34)), LottoRank.FOURTH),
                Arguments.of(new Lotto(List.of(2, 5, 6, 7, 14, 34)), LottoRank.THIRD),
                Arguments.of(new Lotto(List.of(2, 5, 6, 7, 14, 8)), LottoRank.SECOND),
                Arguments.of(new Lotto(List.of(2, 5, 6, 7, 14, 31)), LottoRank.FIRST)
        );
    }

}