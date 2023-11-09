package lotto.global;

import lotto.global.constant.BonusNumberMatch;
import lotto.global.constant.LottoRank;
import lotto.global.constant.exception.ExceptionMessage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.global.constant.LottoRank.*;
import static org.assertj.core.api.Assertions.*;

public class LottoRankTest {

    @Test
    void 숫자_다섯_개_맞추고_보너스_숫자_맞춘_경우_2등이_나오는지_확인() {
        int matchCnt = 5;
        BonusNumberMatch bonusNumberMatch = BonusNumberMatch.MATCH;

        LottoRank result = LottoRank.getRank(matchCnt, bonusNumberMatch);

        assertThat(result)
                .isEqualTo(LottoRank.SECOND_PLACE);
    }

    @Test
    void 숫자_다섯_개_맞추고_보너스_숫자_틀린_경우_3등이_나오는지_확인() {
        int matchCnt = 5;
        BonusNumberMatch bonusNumberMatch = BonusNumberMatch.NOT_MATCH;

        LottoRank result = LottoRank.getRank(matchCnt, bonusNumberMatch);

        assertThat(result)
                .isEqualTo(LottoRank.THIRD_PLACE);
    }

    @Test
    void 맞춘_숫자개수가_3에서_6이고_5가_아닌_경우_등수가_잘_나오는지_확인() {
        List<Integer> matchCounts = List.of(3,4,6);
        List<LottoRank> expected = List.of(FIFTH_PLACE, FOURTH_PLACE, FIRST_PLACE);

        int matchCnt = 3;
        BonusNumberMatch bonusNumberMatch = BonusNumberMatch.NOT_MATTER;

        for(int i = 0; i<matchCounts.size(); i++) {
            LottoRank result = LottoRank.getRank(matchCounts.get(i), bonusNumberMatch);

            assertThat(result)
                    .isEqualTo(expected.get(i));
        }
    }

    @Test
    void 맞춘_숫자개수가_3미만인_경우_등수가_잘_나오는지_확인() {

        int matchCnt = 2;
        BonusNumberMatch bonusNumberMatch = BonusNumberMatch.NOT_MATTER;

        LottoRank result = LottoRank.getRank(matchCnt, bonusNumberMatch);

        assertThat(result)
                .isEqualTo(OUT_OF_RANK);
    }

    @Test
    void 맞춘_숫자개수가_범위_밖일_경우_예외를_던지는지_확인() {
        List<Integer> outOfRangeNumber = List.of(-1,7);

        BonusNumberMatch bonusNumberMatch = BonusNumberMatch.NOT_MATTER;

        for (Integer number : outOfRangeNumber) {
            assertThatThrownBy(() -> LottoRank.getRank(number, bonusNumberMatch))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.ILLEGAL_MATCH_COUNT.getMessage());

        }
    }


}
