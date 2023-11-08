package lotto.DomainTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.Domain.LottoStore;
import lotto.Domain.LottoSystem;
import lotto.Util.WinningStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import lotto.Util.WinningStatistics;

public class LottoStoreTest {

    private LottoStore lottoStore;

    @BeforeEach
    void init() {
        lottoStore = new LottoStore();
    }

    @DisplayName("당첨 보상을 잘 계산하는가?")
    @Test
    void caculateTotalLottoRewardTest(){
        Map<String, Integer> input = new HashMap<>();
        input.put("2", 1);
        input.put("3", 1); // 일반번호 3개와 보너스번호가 1개 맞으면, 4개 당첨이 아니라 3개 당첨이다.
        input.put("7", 1);

        double expected = (double)5000 + 2000000000; // 일 것이다.
        assertThat(lottoStore.caculateTotalLottoReward(input)).isEqualTo(expected);
    }

    @DisplayName("존재하는 당첨 종류인가?")
    @Test
    void isExistingWinningTypeTest(){
        Map<String, Integer> resultNull = new HashMap<>();
        Map<String, Integer> resultThreeMatch = new HashMap<>();
        Map<String, Integer> resultFourMatch = new HashMap<>();
        Map<String, Integer> resultFiveMatch = new HashMap<>();
        Map<String, Integer> resultFiveAndBonusMatch = new HashMap<>();
        Map<String, Integer> resultSixMatch = new HashMap<>();
        resultNull.put("2", 1);
        resultThreeMatch.put("3", 1);
        resultFourMatch.put("4", 1);
        resultFiveMatch.put("5", 1);
        resultFiveAndBonusMatch.put("6", 1);
        resultSixMatch.put("7", 1);

        WinningStatistics.values()[0].getWinningType(); // return = "3" -> 3개 일치
        WinningStatistics.values()[1].getWinningType(); // return = "4" -> 4개 일치
        WinningStatistics.values()[2].getWinningType(); // return = "5" -> 5개 일치
        WinningStatistics.values()[3].getWinningType(); // return = "6" -> 5개 + 보너스 일치
        WinningStatistics.values()[4].getWinningType(); // return = "7" -> 6개 일치

        assertThat(lottoStore.isExistingWinningType(resultNull, WinningStatistics.values()[0])).isEqualTo(false); // 2개 일치는 존재 x
        assertThat(lottoStore.isExistingWinningType(resultThreeMatch, WinningStatistics.values()[0])).isEqualTo(true); // 3개 일치
        assertThat(lottoStore.isExistingWinningType(resultFourMatch, WinningStatistics.values()[1])).isEqualTo(true); // 4개 일치
        assertThat(lottoStore.isExistingWinningType(resultFiveMatch, WinningStatistics.values()[2])).isEqualTo(true); // 5개 일치
        assertThat(lottoStore.isExistingWinningType(resultFiveAndBonusMatch, WinningStatistics.values()[3])).isEqualTo(true); // 5개 + 보너스 일치
        assertThat(lottoStore.isExistingWinningType(resultSixMatch, WinningStatistics.values()[4])).isEqualTo(true); // 6개 일치
    }
}
