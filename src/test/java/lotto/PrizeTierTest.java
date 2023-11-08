package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTierTest {
    @DisplayName("각 PrizeTier에 대한 상금 테스트")
    @Test
    void prizeMoneyTest() {
        int[] prizeMoneys = {0, 5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000};

        PrizeTier[] prizeTiers = PrizeTier.values();

        for (int i = 0; i < prizeTiers.length; i++) {
            Assertions.assertEquals(prizeMoneys[i], prizeTiers[i].getPrizeMoney());
        }
    }

    @DisplayName("일치하는 당첨 번호 수가 0개와 보너스 번호가 일치하지 않을때에 대한 PrizeTier 반환 테스트")
    @Test
    void getPrizeTierTest_0_0() {
        Assertions.assertEquals(PrizeTier.NONE, PrizeTier.getPrizeTier(0, false));
    }

    @DisplayName("일치하는 당첨 번호 수가 3개와 보너스 번호가 일치하지 않을때에 대한 PrizeTier 반환 테스트")
    @Test
    void getPrizeTierTest_3_0() {
        Assertions.assertEquals(PrizeTier.FIFTH, PrizeTier.getPrizeTier(3, false));
    }

    @DisplayName("일치하는 당첨 번호 수가 4개와 보너스 번호가 일치하지 않을때에 대한 PrizeTier 반환 테스트")
    @Test
    void getPrizeTierTest_4_0() {
        Assertions.assertEquals(PrizeTier.FOURTH, PrizeTier.getPrizeTier(4, false));
    }

    @DisplayName("일치하는 당첨 번호 수가 5개와 보너스 번호가 일치하지 않을때에 대한 PrizeTier 반환 테스트")
    @Test
    void getPrizeTierTest_5_0() {
        Assertions.assertEquals(PrizeTier.THIRD, PrizeTier.getPrizeTier(5, false));
    }

    @DisplayName("일치하는 당첨 번호 수가 5개와 보너스 번호가 일치할 때에 대한 PrizeTier 반환 테스트")
    @Test
    void getPrizeTierTest_5_1() {
        Assertions.assertEquals(PrizeTier.SECOND, PrizeTier.getPrizeTier(5, true));
    }

    @DisplayName("일치하는 당첨 번호 수가 6개와 보너스 번호가 일치하지 않을때에 대한 PrizeTier 반환 테스트")
    @Test
    void getPrizeTierTest_6_0() {
        Assertions.assertEquals(PrizeTier.FIRST, PrizeTier.getPrizeTier(6, false
        ));
    }
}
