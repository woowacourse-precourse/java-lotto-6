package lotto.service.manager;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class RankBoardTest {

    @DisplayName("추첨 결과들을 기록한 보드가 총 상금과 읽기 보드를 정상적으로 반환한다.")
    @Test
    public void getTotalPrizeAndResultBoardSuccessAfterNote() throws  Exception {
        //given
        RankBoard rankBoard = new RankBoard();
        List<Rank> ranks = getRanks();
        int countFirstRank = 1;
        int countSecondRank = 2;
        int countThirdRank = 3;
        int countFourthRank = 4;
        int countFifthRank = 5;

        long expectedTotalPrize = getExpectedTotalPrize(countFirstRank, countSecondRank, countThirdRank, countFourthRank, countFifthRank);
        //when
        rankBoard.note(ranks);
        long totalPrizeResult = rankBoard.getTotalPrize();
        Map<Rank, Long> resultBoard = rankBoard.getResultBoard();
        //then
        Assertions.assertThat(totalPrizeResult).isEqualTo(expectedTotalPrize);

        assertCountRank(
                countFirstRank,
                resultBoard.get(
                        Rank.FIRST
                )
        );

        assertCountRank(
                countSecondRank,
                resultBoard.get(
                        Rank.SECOND
                )
        );

        assertCountRank(
                countThirdRank,
                resultBoard.get(
                        Rank.THIRD
                )
        );

        assertCountRank(
                countFourthRank,
                resultBoard.get(
                        Rank.FOURTH
                )
        );

        assertCountRank(
                countFifthRank,
                resultBoard.get(
                        Rank.FIFTH
                )
        );

    }

    private static void assertCountRank(int countRank, Long result) {
        Assertions.assertThat(result).isEqualTo(countRank);
    }

    private static long getExpectedTotalPrize(
            int countFirstRank,
            int countSecondRank,
            int countThirdRank,
            int countFourthRank,
            int countFifthRank
    )
    {
        return ((long) Rank.FIRST.getPrize() * countFirstRank) +
                ((long) Rank.SECOND.getPrize() * countSecondRank) +
                ((long) Rank.THIRD.getPrize() * countThirdRank) +
                ((long) Rank.FOURTH.getPrize() * countFourthRank) +
                (long) Rank.FIFTH.getPrize() * countFifthRank;
    }

    private static List<Rank> getRanks() {
        return List.of(
                Rank.FIRST,

                Rank.SECOND,
                Rank.SECOND,

                Rank.THIRD,
                Rank.THIRD,
                Rank.THIRD,

                Rank.FOURTH,
                Rank.FOURTH,
                Rank.FOURTH,
                Rank.FOURTH,

                Rank.FIFTH,
                Rank.FIFTH,
                Rank.FIFTH,
                Rank.FIFTH,
                Rank.FIFTH
        );
    }

}