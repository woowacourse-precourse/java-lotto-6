package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class WinningTest {

    Winning winning = new Winning();

    @DisplayName("당첨 번호의 개수가 6개가 아니라면 예외가 발생한다.")
    @Test
    void createNumbersByOverSize() {
        assertThrows(IllegalArgumentException.class,
                () -> winning.setListNumber("1,2,3,4,5,6,7"));
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createNumbersByDuplicatedNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> winning.setListNumber("1,2,3,4,5,5"));
    }

    @DisplayName("당첨 번호가 1과 45사이가 아니었으면 예외가 발생한다.")
    @Test
    void createNumbersByOverRange() {
        assertThrows(IllegalArgumentException.class,
                () -> winning.setListNumber("1,2,3,4,55,6"));
    }

    @DisplayName("보너스 번호가 1과 45사이가 아니었으면 예외가 발생한다.")
    @Test
    void createBonusByOverRange() {
        assertThrows(IllegalArgumentException.class,
                () -> winning.setBonus("400"));
    }

    @DisplayName("보너스 번호가 당첨번호와 중복이면 예외가 발생한다.")
    @Test
    void createBonusByDuplicatedNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            winning.setListNumber("1,2,3,4,5,6");
            winning.setBonus("1");
        });
    }
}