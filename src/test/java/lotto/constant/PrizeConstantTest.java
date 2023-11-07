package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeConstantTest {

    @DisplayName("점수로 메세지를 가져온다.")
    @Test
    void getMessageByScore(){
        //given
        int score = 3;

        //when
        String messageByScore = PrizeConstant.getMessageByScore(score);

        //then
        assertThat(messageByScore)
                .contains("3개 일치 (5,000원) - ");
    }

    @DisplayName("점수에 해당하는 메세지가 없으면 없다는 메세지를 반환한다.")
    @Test
    void getMessageByUnknownScore(){
        //given
        int score = 0;

        //when
        String messageByScore = PrizeConstant.getMessageByScore(score);

        //then
        assertThat(messageByScore)
                .contains("일치하는 메시지가 없습니다.");
    }

    @DisplayName("점수에 해당하는 상금을 반환한다.")
    @Test
    void getRewardByScore(){
        //given
        int score = 5;

        //when
        int rewardByScore = PrizeConstant.getRewardByScore(score);

        //then
        assertThat(rewardByScore).isEqualTo(1500000);
    }

    @DisplayName("점수에 해당하는 상금이 없으면 0을 반환한다.")
    @Test
    void getRewardByScoreWithUnknownScore(){
        //given
        int score = 1;

        //when
        int rewardByScore = PrizeConstant.getRewardByScore(score);

        //then
        assertThat(rewardByScore).isEqualTo(0);
    }

}