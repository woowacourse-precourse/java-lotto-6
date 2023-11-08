package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateOfReturnTest {
    @Test
    void 수익률_숫자_검증_테스트() {
        RateOfReturn lottoReturn = new RateOfReturn(10000, 300000);
        RateOfReturn lottoReturn2 = new RateOfReturn(2000000, 6500000);

        System.out.println(lottoReturn.getReturnOfRate());
        System.out.println(lottoReturn2.getReturnOfRate());

        assertEquals(3.33, lottoReturn.getReturnOfRate());
        assertEquals(30.77, lottoReturn2.getReturnOfRate());
    }
}
