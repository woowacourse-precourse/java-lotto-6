package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeResultTest {

    @Test
    @DisplayName("당첨된 상금들을 받아 FAIL을 제외 하고 각 종류 별로 갯수를 카운팅하여 그 결과를 생성한다. ")
    void createPrizeResult() throws Exception {
        //given
        List<Prize> prizes = List.of(Prize.FIRST, Prize.FIRST, Prize.SECOND, Prize.THIRD);
        //when
        Map<Prize, Integer> result = new PrizeResult(prizes).getResult();
        //then

        assertAll(
                () -> assertEquals(2, result.get(Prize.FIRST)),
                () -> assertEquals(1, result.get(Prize.SECOND)),
                () -> assertEquals(1, result.get(Prize.THIRD)),
                () -> assertEquals(0, result.get(Prize.FOURTH)),
                () -> assertEquals(0, result.get(Prize.FIFTH))
        );
    }

}