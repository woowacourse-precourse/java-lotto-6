package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningMoneyTest {
    @Test
    void 당첨금_숫자_검증_테스트(){
        List<Integer> list = new ArrayList<>(Arrays.asList(0,1,0,0,0,2));
        WinningMoney winningMoney = new WinningMoney(list);

        assertTrue(winningMoney.getWinningMoney() == 2000010000);
    }
}
