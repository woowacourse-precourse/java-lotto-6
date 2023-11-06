package domain;

import domain.enums.LottoRank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    @Test
    void 당첨_번호_일치_테스트(){
        Lotto winningNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Lotto userLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertEquals(LottoRank.FIRST, winningLotto.match(userLotto));

        userLotto = new Lotto(Arrays.asList(1,2,3,4,5,7));
        assertEquals(LottoRank.SECOND, winningLotto.match(userLotto));

        userLotto = new Lotto(Arrays.asList(1,2,3,4,5,8));
        assertEquals(LottoRank.THIRD, winningLotto.match(userLotto));

        userLotto = new Lotto(Arrays.asList(1,2,3,4,7,8));
        assertEquals(LottoRank.FOURTH, winningLotto.match(userLotto));

        userLotto = new Lotto(Arrays.asList(1,2,3,7,8,9));
        assertEquals(LottoRank.FIFTH, winningLotto.match(userLotto));

        userLotto = new Lotto(Arrays.asList(1,2,7,8,9,10));
        assertEquals(LottoRank.NONE, winningLotto.match(userLotto));

        userLotto = new Lotto(Arrays.asList(1,7,8,9,10,11));
        assertEquals(LottoRank.NONE, winningLotto.match(userLotto));
    }
}