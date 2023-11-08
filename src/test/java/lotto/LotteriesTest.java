package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.Lotteries;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LotteriesTest {
    @DisplayName("Lotto와 Winning Number 일치하는 값을 정확히 계산한다")
    @ParameterizedTest
    @MethodSource("statisticsLottoNumber")
    void statisticsWinningLotto( List<Integer> lottoNumber,MatchNumber expected ) {
        //given
        Lotteries lotteries = new Lotteries(5);
        List<Integer> winningNumber= List.of(1,2,3,4,5,6);
        int bonusNumber = 1;
        //when
        MatchNumber result = lotteries.compareLottoNumber(winningNumber,lottoNumber,bonusNumber);
        //then
        assertThat(expected).isEqualTo(result);


    }
    public static Stream<Arguments> statisticsLottoNumber() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), MatchNumber.SIX),
                Arguments.arguments(List.of(2, 3, 4, 5, 6, 7), MatchNumber.FIVE),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 7), MatchNumber.FIVE_WITH_BONUS),
                Arguments.arguments(List.of(7, 8, 3, 4, 5, 6), MatchNumber.FOUR),
                Arguments.arguments(List.of(7, 8, 9, 4, 5, 6), MatchNumber.THREE),
                Arguments.arguments(List.of(7, 8, 9, 10, 5, 6), MatchNumber.NONE),
                Arguments.arguments(List.of(7, 8, 9, 10, 11, 6), MatchNumber.NONE),
                Arguments.arguments(List.of(7, 8, 9, 10, 11, 12), MatchNumber.NONE)
        );
    }
}