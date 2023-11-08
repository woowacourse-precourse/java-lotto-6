package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.vo.BonusNumber;
import lotto.vo.WinningNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTicketsTest {

    private static Stream<Arguments> provideLottoTicketsData() {
        return Stream.of(
                Arguments.of(
                        WinningNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        BonusNumber.from(7),
                        List.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))),
                        createExpectedRankResult() // 일치하는 경우
                )
        );
    }

    private static RankResult createExpectedRankResult() {
        RankResult result = RankResult.create();
        result.add(LottoRank.FIRST);
        return result;
    }

    @ParameterizedTest
    @MethodSource("provideLottoTicketsData")
    @DisplayName("LottoTickets는 당첨 번호와 보너스 번호를 평가하여 올바른 RankResult를 생성해야 한다")
    void testEvaluateWinningStatus(WinningNumbers winningNumbers,
                                   BonusNumber bonusNumber,
                                   List<Lotto> tickets,
                                   RankResult expected) {
        LottoTickets lottoTickets = LottoTickets.from(tickets);
        RankResult actual = lottoTickets.evaluateWinningStatus(winningNumbers, bonusNumber);

        // 각 LottoRank에 대한 검증
        for (LottoRank rank : LottoRank.values()) {
            Assertions.assertEquals(expected.getCount(rank), actual.getCount(rank));
        }
        // 총 당첨금에 대한 검증
        Assertions.assertEquals(expected.calculateTotalWinnings(), actual.calculateTotalWinnings());
    }
}
