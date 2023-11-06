package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import lotto.Controller.Request;
import lotto.vo.winning.LottoWinning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest extends NsTest {
    Request request = new Request();

    @DisplayName("정상 입력")
    @Test
    void RequestLottoWinning_Bonus_Number_테스트() {
        List<Integer> winningnumber = new ArrayList<>();
        winningnumber.add(1);
        winningnumber.add(2);
        winningnumber.add(3);
        winningnumber.add(4);
        winningnumber.add(5);
        winningnumber.add(6);
        int bonusnumber = 7;
        assertSimpleTest(() -> {
            runException("1,2,3,4,5,6", "7");
        });
        assertEquals(LottoWinning.GetBonusNumber(), bonusnumber);
        assertEquals(LottoWinning.GetWinningNumber().GetLotto(), winningnumber);
    }

    @Override
    public void runMain() {
        request.RequestSetWinningNumber();
    }
}
