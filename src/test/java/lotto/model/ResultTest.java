package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    List<List<Integer>> userLottoNumbers = List.of(List.of(1,2,3,4,5,6), List.of(2,3,4,5,6,7), List.of(3,4,5,6,10,12),List.of(4,5,6,7,20,30));

    List<Integer> lottoWinningNumber = List.of(1,2,3,4,5,6);
    int bonus = 7;
    @Test
    @DisplayName("사용자가 구입한 로또 번호와 정답 로또 번호를 검증한다")
    void 로또_번호와_정답_로또_번호를_검증() {
        Result result = new Result(lottoWinningNumber,userLottoNumbers,bonus);

        assertEquals(result.getLottoMatch(),List.of(6,5,4,3));
    }

    @Test
    @DisplayName("보너스 번호가 일치하는지 검증한다.")
    void 보너스_번호가_일치하는지_검증() {
        Result result = new Result(lottoWinningNumber,userLottoNumbers,bonus);

        assertEquals(result.getHasBonusMatch(),List.of(false,true,false,true));
    }

}