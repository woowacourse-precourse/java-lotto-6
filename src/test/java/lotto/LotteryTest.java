package lotto;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteryTest {

    @DisplayName("실제 당첨 번호와 입력한 당첨 번호가 몇 개나 일치하는지 확인")
    @Test
    void 맞힌_번호_갯수_테스트() throws Exception {
        List<Integer> customWinningNumbers = Arrays.asList(1, 2, 3, 21, 22, 23);
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lottery lottery = new Lottery(lottoNumbers, 7);

        Field winningNumberField = Lottery.class.getDeclaredField("winningNumbers");
        Field rankField = Lottery.class.getDeclaredField("rank");
        winningNumberField.setAccessible(true);
        rankField.setAccessible(true);
        winningNumberField.set(lottery, customWinningNumbers);
        rankField.set(lottery, Rank.FIFTH);
        System.out.println(lottery.getRank());
        //입력한 당첨 번호: 1,2,3,4,5,6
        //보너스 번호: 7
        //실제 당첨 번호: 1,2,3,21,22,23
        //등수: FIFTH

        int matchingNumbers = lottery.matchingNumbers(lottoNumbers);
        Assertions.assertThat(matchingNumbers).isEqualTo(3);
    }

    @DisplayName("등수 계산")
    @Test
    void 등수_계산_테스트() throws Exception {
        List<Integer> customWinningNumbers = Arrays.asList(1, 2, 3, 21, 22, 23);
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lottery lottery = new Lottery(lottoNumbers, 7);

        Field winningNumberField = Lottery.class.getDeclaredField("winningNumbers");
        Field rankField = Lottery.class.getDeclaredField("rank");
        winningNumberField.setAccessible(true);
        rankField.setAccessible(true);
        winningNumberField.set(lottery, customWinningNumbers);
        rankField.set(lottery, Rank.FIFTH);
        System.out.println(lottery.getRank());
        //입력한 당첨 번호: 1,2,3,4,5,6
        //보너스 번호: 7
        //실제 당첨 번호: 1,2,3,21,22,23
        //등수: FIFTH

        Rank rank = lottery.whatIsRank(lottoNumbers, 7);
        Assertions.assertThat(rank).isEqualTo(Rank.FIFTH);
    }

}
