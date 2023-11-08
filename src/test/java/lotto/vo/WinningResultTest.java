package lotto.vo;

import lotto.values.CorrectNumber;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class WinningResultTest {

    @Test
    void test(){
        WinningResult winningResult = new WinningResult();
        winningResult.win(CorrectNumber.SECOND_PLACE);
        winningResult.win(CorrectNumber.SECOND_PLACE);
        winningResult.win(CorrectNumber.FIFTH_PLACE);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(0);
        list.add(2);
        list.add(0);

        assertEquals(list, winningResult.getWinning());
    }
}