package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyerTest {
    @Test
    @DisplayName("::번호가 3개가 일치하여 5등 객체를 반환합니다.")
    public void When_MatchThreeNumbers_Then_RankIsFiFTH() {
        //Given
        Lotto buyerNumbers = Lotto.create("1,2,3,4,5,6");

        Lotto randomLotto = Lotto.create("1,2,3,7,8,9");

        Buyer buyer = Buyer.create(buyerNumbers, 7);

        //When
        Rank rank = buyer.calculateComparingResult(randomLotto);

        //Then
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }
}
