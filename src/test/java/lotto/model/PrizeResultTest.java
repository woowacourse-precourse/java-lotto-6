package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PrizeResultTest {
    List<Integer> lottoMatch = List.of(6,5,5,4,3,1);
    List<Boolean> hasBonusMatch = List.of(false,true,false,true,true,false);

    @Test
    @DisplayName("유저가 산 로또 번호의 보상 결과를 확인한다.")
    void 유저의_로또_번호의_보상_결과_검증() {
        PrizeResult prizeResult = new PrizeResult(lottoMatch,hasBonusMatch);

        Assertions.assertEquals(Arrays.asList(Prize.FIRST, Prize.SECOND,Prize.THIRD,Prize.FOURTH,Prize.FIFTH,Prize.NONE), prizeResult.getRanking());
    }

}