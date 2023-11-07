package lotto.domain.model;

import static lotto.domain.model.PrizeConstant.FIFTH_REWARD;
import static lotto.domain.model.PrizeConstant.FIRST_REWARD;
import static lotto.domain.model.PrizeConstant.FOURTH_REWARD;
import static lotto.domain.model.PrizeConstant.SECOND_REWARD;
import static lotto.domain.model.PrizeConstant.THIRD_REWARD;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {


    Rank firstRank = Rank.FIRST_RANK;
    Rank secondRank = Rank.SECOND_RANK;
    Rank thirdRank = Rank.THIRD_RANK;
    Rank fourthRank = Rank.FOURTH_RANK;
    Rank fifthRank = Rank.FIFTH_RANK;

    @Test
    @DisplayName("Rank Enum class는 매칭된 횟수를 필드로 가진다.")
    void getMatchCountTest() throws Exception{
        //when
        int matchCount1 = firstRank.getMatchCount();
        int matchCount2 = secondRank.getMatchCount();
        int matchCount3 = thirdRank.getMatchCount();
        int matchCount4 = fourthRank.getMatchCount();
        int matchCount5 = fifthRank.getMatchCount();
        //then
        Assertions.assertThat(matchCount1).isEqualTo(6);
        Assertions.assertThat(matchCount2).isEqualTo(5);
        Assertions.assertThat(matchCount3).isEqualTo(5);
        Assertions.assertThat(matchCount4).isEqualTo(4);
        Assertions.assertThat(matchCount5).isEqualTo(3);
     }

     @Test
     @DisplayName("Rank Class는 상금 정보를 가진다.")
     void getPrizeTest() throws Exception{
         Rank firstRank = Rank.FIRST_RANK;
         Rank secondRank = Rank.SECOND_RANK;
         Rank thirdRank = Rank.THIRD_RANK;
         Rank fourthRank = Rank.FOURTH_RANK;
         Rank fifthRank = Rank.FIFTH_RANK;
         //when
         int prize1 = firstRank.getPrize();
         int prize2 = secondRank.getPrize();
         int prize3 = thirdRank.getPrize();
         int prize4 = fourthRank.getPrize();
         int prize5 = fifthRank.getPrize();
         //then
         assertThat(prize1).isEqualTo(FIRST_REWARD);
         assertThat(prize2).isEqualTo(SECOND_REWARD);
         assertThat(prize3).isEqualTo(THIRD_REWARD);
         assertThat(prize4).isEqualTo(FOURTH_REWARD);
         assertThat(prize5).isEqualTo(FIFTH_REWARD);
      }

      @Test
      @DisplayName("Rank class는 등수 정보를 가진다.")
      void getOrderTest() throws Exception{
          //when
          int order1 = firstRank.getOrder();
          int order2 = secondRank.getOrder();
          int order3 = thirdRank.getOrder();
          int order4 = fourthRank.getOrder();
          int order5 = fifthRank.getOrder();
          //then
          assertThat(order1).isEqualTo(1);
          assertThat(order2).isEqualTo(2);
          assertThat(order3).isEqualTo(3);
          assertThat(order4).isEqualTo(4);
          assertThat(order5).isEqualTo(5);
       }
}