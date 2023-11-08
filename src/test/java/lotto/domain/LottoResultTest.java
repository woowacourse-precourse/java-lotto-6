package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class LottoResultTest {

    LottoResult lottoResult;

    @BeforeEach
    public void before() {
        lottoResult = new LottoResult();
    }

    @DisplayName("등수 결과 추가하기")
    @Test
    public void 등수_결과_추가() throws Exception {
        //given (주어진 값)
        int zero = 0;
        int one = 1;
        int two = 2;
        int three = 3;
        int four = 4;
        int five = 5;
        int fiveAndBonus = 50;
        int six = 6;

        lottoResult.addWinningCount(zero);
        lottoResult.addWinningCount(one);
        lottoResult.addWinningCount(two);
        lottoResult.addWinningCount(three);
        lottoResult.addWinningCount(four);
        lottoResult.addWinningCount(five);
        lottoResult.addWinningCount(fiveAndBonus);
        lottoResult.addWinningCount(six);
        lottoResult.addWinningCount(six);

        //when (기능 작동)
        Map<Integer, Integer> resultCount = lottoResult.getWinningCount();

        //then (기능 작동 후 결과)
        Assertions.assertThat(resultCount.get(3)).isEqualTo(1);
        Assertions.assertThat(resultCount.get(4)).isEqualTo(1);
        Assertions.assertThat(resultCount.get(5)).isEqualTo(1);
        Assertions.assertThat(resultCount.get(50)).isEqualTo(1);
        Assertions.assertThat(resultCount.get(6)).isEqualTo(2);
    }
}