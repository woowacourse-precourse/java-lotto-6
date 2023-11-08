package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class BankTest {


    @DisplayName("당첨 번호와 로또 번호 일치하는 개수 테스트")
    @Test
    public void testCountCorrect() {
        //given
        Bank bank = new Bank();
        bank.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        int correctCount = bank.countCorrect(lotto);
        //then
        assertEquals(6, correctCount);
    }

    @DisplayName("로또 번호들 중 보너스 번호와 일치하는 값이 존재하면 true 반환")
    @Test
    public void testIsMatchBonusTrue() {
        //given
        Bank bank = new Bank();
        bank.setExtraWinningNumber(6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        Boolean matchBonus = bank.isMatchBonus(lotto);
        //then
        Assertions.assertEquals(true, matchBonus);
    }

    @DisplayName("로또 번호들 중 보너스 번호와 일치하는 값이 존재하면 false 반환")
    @Test
    public void testIsMatchBonusFalse() {
        //given
        Bank bank = new Bank();
        bank.setExtraWinningNumber(7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        Boolean matchBonus = bank.isMatchBonus(lotto);
        //then
        Assertions.assertEquals(false, matchBonus);
    }

    @DisplayName("player의 money와 상금을 나눠 earningRate 계산")
    @Test
    public void testCalculateEarningRate() {
        //given
        Bank bank = new Bank();
        Player player = new Player("10000");
        //when
        double earningRate = bank.calculateEarningRate(15000, player);
        //then
        assertEquals(150.0, earningRate, 0.01);
    }
}