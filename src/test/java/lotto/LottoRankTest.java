package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {
    @DisplayName("당첨 숫자와 일치하는 숫자 및 보너스로 당첨 여부 및 상금을 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "6, false, 2000000000",
            "6, true, 2000000000",
            "5, true, 30000000",
            "5, false, 1500000",
            "4, true, 50000",
            "3, false, 5000",
            "2, true, 0",
            "2, false, 0",
            "1, true, 0",
            "0, true, 0",
    })
    void testGetWinningRank(int match, boolean bonus, long expected) {
        LottoRank rank = LottoRank.getWinningRank(match, bonus);
        if (rank == null) {
            assertEquals(expected, 0);
            return;
        }
        long actual = LottoRank.getWinningRank(match, bonus).getReward();
        assertEquals(expected, actual);
    }

    @Test
    void testCompare(){
        List<LottoRank> expected = List.of(
                LottoRank.THIRD_PLACE,
                LottoRank.SECOND_PLACE,
                LottoRank.FIRST_PLACE
        );
        List<LottoRank> actual = new ArrayList<>();
        actual.add(LottoRank.SECOND_PLACE);
        actual.add(LottoRank.THIRD_PLACE);
        actual.add(LottoRank.FIRST_PLACE);
        actual.sort(LottoRank::compare);

        assertEquals(expected, actual);
    }
}
