package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStatisticsTest {
    // 그냥 로또번호와 보너스 번호 중복인지 테스트도 필요
    private final LottoWinCheck lottoWinCheck = new LottoWinCheck(Arrays.asList(1,2,3,4,5,6), 7);
    private final LottoStatistics lottoStatistics = new LottoStatistics(lottoWinCheck);

    @Test
    @DisplayName("5개가 일치하면서 보너스 버호도 맞았을때 50이 들어오는지 테스트")
    public void bonusCheckTest() {
       List<Integer> userNums = Arrays.asList(1,2,3,4,5,8);
       int matchCount = 50;

       assertEquals(lottoStatistics.getBonusNumber(userNums, matchCount), matchCount);
    }

    @Test
    @DisplayName("당첨개수에 따라 올바른 당첨 카운트 테스트")
    void matchCountTest(){
        List<Integer> testNums1 = Arrays.asList(1,2,3,8,9,10);
        List<Integer> testNums2 = Arrays.asList(1,2,3,4,8,9);
        List<Integer> testNums3 = Arrays.asList(1,2,3,4,5,6);
        assertEquals(lottoStatistics.getMatchCount(testNums1), 3);
        assertEquals(lottoStatistics.getMatchCount(testNums2), 4);
        assertEquals(lottoStatistics.getMatchCount(testNums3), 6);

    }

}
