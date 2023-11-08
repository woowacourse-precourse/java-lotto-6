package lotto;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ServiceTest {

    @Test
    void 문자_입력시_에러발생() {
        Assertions.assertThatThrownBy(() -> Service.isNumber("가나다"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 천의배수_아니면_에러발생() {
        Assertions.assertThatThrownBy(() -> Service.numberOfLottery(123))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 수가 1000의 배수가 아닐 때 에러 발생")
    @Test
    void 수의_범위_테스트() {
        Assertions.assertThatThrownBy(() -> Service.rangeValidation(123))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호로 입력한 숫자를 보너스 번호로 중복해서 입력했을 떄 에러 발생")
    @Test
    void 보너스_번호_유효성_테스트() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        Assertions.assertThatThrownBy(() -> Service.bonusRedundancyCheck(numbers, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메서드로 생성된 맵과 예상하는 맵이 일치하면 테스트 통과")
    @Test
    void 순위집계_맵_생성_테스트() throws Exception{
        List<Integer> customWinningNumbers = Arrays.asList(1,2,3,21,22,23);
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);
        Lottery lottery = new Lottery(lottoNumbers, 7);

        Field winningNumberField = Lottery.class.getDeclaredField("winningNumbers");
        Field rankField = Lottery.class.getDeclaredField("rank");
        winningNumberField.setAccessible(true);
        rankField.setAccessible(true);
        winningNumberField.set(lottery, customWinningNumbers);
        rankField.set(lottery, Rank.FIFTH);
        List<Lottery> lotteries = Arrays.asList(lottery);
        System.out.println(lottery.getRank());
        //입력한 당첨 번호: 1,2,3,4,5,6
        //보너스 번호: 7
        //실제 당첨 번호: 1,2,3,21,22,23
        //등수: FIFTH

        Map<Rank, Long> expectedMap = new HashMap<>();
        expectedMap.put(Rank.FIRST, 0L);
        expectedMap.put(Rank.SECOND, 0L);
        expectedMap.put(Rank.THIRD, 0L);
        expectedMap.put(Rank.FORTH, 0L);
        expectedMap.put(Rank.FIFTH, 1L);
        expectedMap.put(Rank.NONE, 0L);

        Map<Rank, Long> realMap = Service.makeRankCountMap(lotteries);

        Assertions.assertThat(expectedMap).isEqualTo(realMap);
    }

    @DisplayName("수익률이 50f로 계산되면 테스트 성공")
    @Test
    void 수익률_계산_테스트() {
        Map<Rank, Long> rankCountMap = new HashMap<>();
        rankCountMap.put(Rank.FIRST, 0L);
        rankCountMap.put(Rank.SECOND, 0L);
        rankCountMap.put(Rank.THIRD, 0L);
        rankCountMap.put(Rank.FORTH, 0L);
        rankCountMap.put(Rank.FIFTH, 1L);
        rankCountMap.put(Rank.NONE, 0L);
        float rateOfReturn = Service.calculateRateOfReturn(rankCountMap, 10000);
        Assertions.assertThat(rateOfReturn).isEqualTo(50f);
    }

}