package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningRankTest {

    @Test
    void testSecondRankToString() {
        WinningRank secondRank = WinningRank.SECOND;
        String expected = "5개 일치, 보너스 볼 일치 (30,000,000원)";
        Assertions.assertThat(secondRank.toString()).isEqualTo(expected);
    }

    @Test
    void testOtherRanksToString() {
        WinningRank firstRank = WinningRank.FIRST;
        WinningRank thirdRank = WinningRank.THIRD;
        WinningRank fourthRank = WinningRank.FOURTH;
        WinningRank fifthRank = WinningRank.FIFTH;

        String expectedFirst = "6개 일치, (2,000,000,000원)";
        String expectedThird = "5개 일치, (1,500,000원)";
        String expectedFourth = "4개 일치, (50,000원)";
        String expectedFifth = "3개 일치, (5,000원)";

        Assertions.assertThat(firstRank.toString()).isEqualTo(expectedFirst);
        Assertions.assertThat(thirdRank.toString()).isEqualTo(expectedThird);
        Assertions.assertThat(fourthRank.toString()).isEqualTo(expectedFourth);
        Assertions.assertThat(fifthRank.toString()).isEqualTo(expectedFifth);
    }


}