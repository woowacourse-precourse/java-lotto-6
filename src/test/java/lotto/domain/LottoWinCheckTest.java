package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinCheckTest {

    private final LottoWinCheck lottoWinCheck = new LottoWinCheck( Arrays.asList(1,2,3,4,5,6), 3);
    @Test
    @DisplayName("3개가 맞았을 때 숫자가 제대로 나오는지 확인")
    public void winCheckTestSomeMatches(){
        List<Integer> player = Arrays.asList(1,22,31,32,5,6);

        assertEquals(3, lottoWinCheck.winningCheck(player));
    }

    @Test
    @DisplayName("모두 맞았을 때 숫자가 제대로 나오는지 확인")
    public void winCheckTestAllMatches(){
        List<Integer> player = Arrays.asList(1,2,3,4,5,6);

        assertEquals(6, lottoWinCheck.winningCheck(player));
    }

    @Test
    @DisplayName("모두 안맞았을 때 숫자가 제대로 나오는지 확인")
    public void winCheckTestNotMatches(){
        List<Integer> player = Arrays.asList(11,12,13,14,15,16);

        assertEquals(0, lottoWinCheck.winningCheck(player));
    }

    @Test
    @DisplayName("보너스 숫자가 맞았을때 나오는지 확인")
    public void bonusWinCheck(){
        assertTrue(lottoWinCheck.bonusWinningCheck());
    }
}
