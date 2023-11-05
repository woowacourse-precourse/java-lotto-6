package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    @DisplayName("사용자가 구입한 로또 번호와 정답 로또 번호를 검증한다")
    void 로또_결과를_검증() {
        List<List<Integer>> userLottoNumbers = List.of(List.of(1,2,3,4,5,6), List.of(2,3,4,5,6,7), List.of(3,4,5,6,10,12),List.of(4,5,6,7,20,30));

        List<Integer> lottoWinningNumber = List.of(1,2,3,4,5,6);
        int bonus = 7;

        Result result = new Result(lottoWinningNumber,userLottoNumbers,bonus);

        assertEquals(result.getMatch(),List.of(6,5,4,3));
        assertEquals(result.getHasBonus(),List.of(false,true,false,true));
    }

}