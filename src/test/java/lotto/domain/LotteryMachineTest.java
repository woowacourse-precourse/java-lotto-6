package lotto.domain;

import lotto.dto.WinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryMachineTest {

    @DisplayName("로또 번호 매칭 판단 테스트")
    @ParameterizedTest
    @MethodSource("lottoProvider")
    public void LotteryMachineCalculateRankTest(List<LottoNumber> winnerNumbers, LottoNumber bonusNumber, WinningResult expected) {
        // given
        List<Lotto> lottos = makeLottos();

        // when
        WinningResult winningResult = new LotteryMachine().judge(lottos, winnerNumbers, bonusNumber);

        // then
        assertThat(winningResult.equals(expected)).isTrue();
    }

    private List<Lotto> makeLottos() {
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6));

        List<LottoNumber> lottoNumbers2 = List.of(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(25), new LottoNumber(27));

        return List.of(new Lotto(lottoNumbers), new Lotto(lottoNumbers2));
    }

    private static Stream<Arguments> lottoProvider() { // argument source method
        List<LottoNumber> winnerNumbers1 = List.of(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6));

        List<LottoNumber> winnerNumbers2 = List.of(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(7));

        List<LottoNumber> winnerNumbers3 = List.of(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(8), new LottoNumber(7));

        List<LottoNumber> winnerNumbers4 = List.of(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(9),
                new LottoNumber(8), new LottoNumber(7));

        List<LottoNumber> winnerNumbers5 = List.of(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(10), new LottoNumber(9),
                new LottoNumber(8), new LottoNumber(7));


        Map<Rank, Integer> expectedRanks1 = new HashMap<>();
        expectedRanks1.put(Rank.FIRST, 1);
        expectedRanks1.put(Rank.FOURTH, 1);

        Map<Rank, Integer> expectedRanks2 = new HashMap<>();
        expectedRanks2.put(Rank.THIRD, 1);
        expectedRanks2.put(Rank.FOURTH, 1);

        Map<Rank, Integer> expectedRanks3 = new HashMap<>();
        expectedRanks3.put(Rank.FOURTH, 2);

        Map<Rank, Integer> expectedRanks4 = new HashMap<>();
        expectedRanks4.put(Rank.FIFTH, 2);

        Map<Rank, Integer> expectedRanks5 = new HashMap<>();
        expectedRanks5.put(Rank.MISS, 2);

        Map<Rank, Integer> expectedRanks6 = new HashMap<>();
        expectedRanks6.put(Rank.SECOND, 1);
        expectedRanks6.put(Rank.THIRD, 1);


        return Stream.of(
                Arguments.of(winnerNumbers1, new LottoNumber(17), new WinningResult(expectedRanks1)),
                Arguments.of(winnerNumbers2, new LottoNumber(17), new WinningResult(expectedRanks2),
                Arguments.of(winnerNumbers3, new LottoNumber(17), new WinningResult(expectedRanks3)),
                Arguments.of(winnerNumbers4, new LottoNumber(17), new WinningResult(expectedRanks4)),
                Arguments.of(winnerNumbers5, new LottoNumber(17), new WinningResult(expectedRanks5)),
                Arguments.of(winnerNumbers2, new LottoNumber(7), new WinningResult(expectedRanks6)))
        );
    }
}
