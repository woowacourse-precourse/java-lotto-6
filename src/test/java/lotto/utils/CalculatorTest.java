package lotto.utils;

import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();
    String[] winningNumbers = {"1","2","3","4","5","6"};
    String bonusNumber = "7";
    WinningLotto winningLotto = new WinningLotto(winningNumbers,bonusNumber);

    @DisplayName("1등 테스트")
    @Test
    void testCalculatingRank1(){
        List<Integer> purchaseLotto = Arrays.asList(1,2,3,4,5,6);
        int rank = calculator.calculatingRank(winningLotto,purchaseLotto);
        assertEquals(rank,1);
    }

    @DisplayName("2등 테스트")
    @Test
    void testCalculatingRank2(){
        List<Integer> purchaseLotto = Arrays.asList(1,2,3,4,5,7);
        int rank = calculator.calculatingRank(winningLotto,purchaseLotto);
        assertEquals(rank,2);
    }

    @DisplayName("3등 테스트")
    @Test
    void testCalculatingRank3(){
        List<Integer> purchaseLotto = Arrays.asList(1,2,3,4,5,9);
        int rank = calculator.calculatingRank(winningLotto,purchaseLotto);
        assertEquals(rank,3);
    }

    @DisplayName("4등 테스트")
    @Test
    void testCalculatingRank4(){
        List<Integer> purchaseLotto = Arrays.asList(1,2,3,4,7,8);
        int rank = calculator.calculatingRank(winningLotto,purchaseLotto);
        assertEquals(rank,4);
    }

    @DisplayName("5등 테스트")
    @Test
    void testCalculatingRank5(){
        List<Integer> purchaseLotto = Arrays.asList(1,2,3,7,8,9);
        int rank = calculator.calculatingRank(winningLotto,purchaseLotto);
        assertEquals(rank,5);
    }

    @DisplayName("꽝 테스트")
    @Test
    void testCalculatingRank6(){
        List<Integer> purchaseLotto = Arrays.asList(7,8,9,10,11,12);
        int rank = calculator.calculatingRank(winningLotto,purchaseLotto);
        assertEquals(rank,6);
    }
}
