package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class WinningResultTest {

    @Test
    public void testMatch() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        int bonusNumber = 7;
        
        WinningResult winningResult = new WinningResult(winningLotto, bonusNumber);
        
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto playerLotto = new Lotto(playerNumbers);
        
        Ranking ranking = winningResult.match(playerLotto);
        
        assertEquals(Ranking.FIRST, ranking); // 1등
    }
}
