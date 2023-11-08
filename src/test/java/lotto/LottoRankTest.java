package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {
    Lotto winningLotto=new Lotto(List.of(1,2,3,4,5,6));
    @DisplayName("숫자가 6개 같을때 1을 반환한다")
    @Test
    void firstPrize(){
        Lotto lotto=new Lotto(winningLotto.getNumbers());
        assertEquals(1,LottoRank.isRank(lotto,winningLotto,0));
    }
    @DisplayName("숫자가 5개 같고, 보너스숫자가 있을 때 2를 반환한다")
    @Test
    void secondPrize(){
        Lotto lotto=new Lotto(List.of(1,2,3,4,5,7));
        assertEquals(2,LottoRank.isRank(lotto,winningLotto,6));
    }
}
