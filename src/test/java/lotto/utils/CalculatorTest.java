package lotto.utils;

import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    String[] winningNumbers = {"1", "2", "3", "4", "5", "6"};
    String bonusNumber = "7";
    WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

    @DisplayName("1등 테스트")
    @Test
    void testCalculatingRank1() {
        List<Integer> purchaseLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        int rank = Calculator.calculatingRank(winningLotto, purchaseLotto);
        assertEquals(rank, 1);
    }

    @DisplayName("2등 테스트")
    @Test
    void testCalculatingRank2() {
        List<Integer> purchaseLotto = Arrays.asList(1, 2, 3, 4, 5, 7);
        int rank = Calculator.calculatingRank(winningLotto, purchaseLotto);
        assertEquals(rank, 2);
    }

    @DisplayName("3등 테스트")
    @Test
    void testCalculatingRank3() {
        List<Integer> purchaseLotto = Arrays.asList(1, 2, 3, 4, 5, 9);
        int rank = Calculator.calculatingRank(winningLotto, purchaseLotto);
        assertEquals(rank, 3);
    }

    @DisplayName("4등 테스트")
    @Test
    void testCalculatingRank4() {
        List<Integer> purchaseLotto = Arrays.asList(1, 2, 3, 4, 7, 8);
        int rank = Calculator.calculatingRank(winningLotto, purchaseLotto);
        assertEquals(rank, 4);
    }

    @DisplayName("5등 테스트")
    @Test
    void testCalculatingRank5() {
        List<Integer> purchaseLotto = Arrays.asList(1, 2, 3, 7, 8, 9);
        int rank = Calculator.calculatingRank(winningLotto, purchaseLotto);
        assertEquals(rank, 5);
    }

    @DisplayName("꽝 테스트")
    @Test
    void testCalculatingRank6() {
        List<Integer> purchaseLotto = Arrays.asList(7, 8, 9, 10, 11, 12);
        int rank = Calculator.calculatingRank(winningLotto, purchaseLotto);
        assertEquals(rank, 6);
    }

    @DisplayName("수익률 계산 테스트 (1등)")
    @Test
    void testCalculateEarningRate1() {
        int amount = 4000;
        List<Integer> ranks = Arrays.asList(1, 6, 6, 6);
        double earningRate = Calculator.calculateEarningRate(amount, ranks);
        assertEquals(earningRate, 50000000);
    }

    @DisplayName("수익률 계산 테스트 (2등)")
    @Test
    void testCalculateEarningRate2() {
        int amount = 4000;
        List<Integer> ranks = Arrays.asList(2, 6, 6, 6);
        double earningRate = Calculator.calculateEarningRate(amount, ranks);
        assertEquals(earningRate, 750000);
    }

    @DisplayName("수익률 계산 테스트 (3등)")
    @Test
    void testCalculateEarningRate3() {
        int amount = 4000;
        List<Integer> ranks = Arrays.asList(3, 6, 6, 6);
        double earningRate = Calculator.calculateEarningRate(amount, ranks);
        assertEquals(earningRate, 37500);
    }

    @DisplayName("수익률 계산 테스트 (4등)")
    @Test
    void testCalculateEarningRate4() {
        int amount = 4000;
        List<Integer> ranks = Arrays.asList(4, 6, 6, 6);
        double earningRate = Calculator.calculateEarningRate(amount, ranks);
        assertEquals(earningRate, 1250);
    }

    @DisplayName("수익률 계산 테스트 (5등)")
    @Test
    void testCalculateEarningRate5() {
        int amount = 4000;
        List<Integer> ranks = Arrays.asList(5, 6, 6, 6);
        double earningRate = Calculator.calculateEarningRate(amount, ranks);
        assertEquals(earningRate, 125);
    }

    @DisplayName("수익률 계산 테스트 (꽝)")
    @Test
    void testCalculateEarningRate6() {
        int amount = 4000;
        List<Integer> ranks = Arrays.asList(6, 6, 6, 6);
        double earningRate = Calculator.calculateEarningRate(amount, ranks);
        assertEquals(earningRate, 0);
    }

    @DisplayName("수익률 계산 테스트 (혼합1)")
    @Test
    void testCalculateEarningRate7() {
        int amount = 4000;
        List<Integer> ranks = Arrays.asList(1, 2, 3, 4);
        double earningRate = Calculator.calculateEarningRate(amount, ranks);
        assertEquals(earningRate, 50788750);
    }
}
