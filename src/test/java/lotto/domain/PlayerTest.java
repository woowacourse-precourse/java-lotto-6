package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    @DisplayName("입력한 금액을 통해 로또를 몇장 살 수 있는지 반환한다.")
    @Test
    void countTickets(){
        //given
        Player player = new Player(16000);
        //when
        assertThat(16).isEqualTo(player.countTickets());
        //then
    }

    @DisplayName("입력한 금액이 1000으로 나누어떨어지지 않으면 예외를 발생시킨다.")
    @Test
    void countTicketsException(){
        //given
        Player player = new Player(13500);
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> player.countTickets());

        assertThat(e.getMessage()).isEqualTo("[ERROR]1,000원 단위로만 입력가능합니다.");
    }
    @DisplayName("당첨 등수가 몇개 있는지 테스트한다.")
    @Test
    void countRankingTest(){
        //given
        Player player = new Player(3000);
        Map<RankingStatus,Integer> expect = new HashMap<RankingStatus, Integer>();
        Arrays.stream(RankingStatus.values())
                .forEach(rank -> expect.put(rank, 0));
        expect.put(RankingStatus.FIRST_RANK, 2);
        expect.put(RankingStatus.THIRD_RANK, 1);

        //when
        player.countRanking(RankingStatus.FIRST_RANK);
        player.countRanking(RankingStatus.FIRST_RANK);
        player.countRanking(RankingStatus.THIRD_RANK);
        //then
        assertThat(expect).isEqualTo(player.rankings);
    }
    @DisplayName("수익률을 계산하는 메서드의 테스트")
    @Test
    void calculateRewardTest(){
        //given
        Player player = new Player(3000);
        player.countRanking(RankingStatus.BOOM);
        player.countRanking(RankingStatus.FIFTH_RANK);
        player.countRanking(RankingStatus.THIRD_RANK);
        //when
        double resultReward = player.calculateReward();
        //then
        assertThat(resultReward).isEqualTo(50166.7);
    }



}
