package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @Test
    @DisplayName("당첨번호와 일치하는 숫자의 갯수와 보너스 번호 일치여부를 확인하여 상금 종류를 찾는다.")
    void findBySameNumberCountAndBonus() throws Exception {
        //given
        int sameNumberCount1 = 6;
        int sameNumberCount2 = 5;
        int sameNumberCount3 = 4;
        int sameNumberCount4 = 3;
        int sameNumberCount5 = 2;

        boolean bonus1 = false;
        boolean bonus2 = true;
        //when
        Prize prize1 = Prize.findBySameNumberCountAndBonus(sameNumberCount1, bonus1);
        Prize prize2 = Prize.findBySameNumberCountAndBonus(sameNumberCount2, bonus2);
        Prize prize3 = Prize.findBySameNumberCountAndBonus(sameNumberCount2, bonus1);
        Prize prize4 = Prize.findBySameNumberCountAndBonus(sameNumberCount3, bonus1);
        Prize prize5 = Prize.findBySameNumberCountAndBonus(sameNumberCount4, bonus1);
        Prize prize6 = Prize.findBySameNumberCountAndBonus(sameNumberCount5, bonus1);
        //then
        assertAll(
                () -> assertEquals(Prize.FIRST, prize1),
                () -> assertEquals(Prize.SECOND, prize2),
                () -> assertEquals(Prize.THIRD, prize3),
                () -> assertEquals(Prize.FOURTH, prize4),
                () -> assertEquals(Prize.FIFTH, prize5),
                () -> assertEquals(Prize.FAIL, prize6)
        );

    }

}