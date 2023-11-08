package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @DisplayName("로또결과를 받는 함수가 잘 작동하는지 확인")
    @Test
    void setLottoResults() {
        // given
        List<Lotto> lottos= List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 11))
        );
        Lotto userLottoNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 12));
        int bonusNumber = 7;
        // when
        Result.getAllLottoResults(lottos, userLottoNumbers, bonusNumber);
        // then
        assertEquals(1, Result.SECOND.getStatus());
    }

    @DisplayName("수익률을 구하는 함수가 잘 작동하는지 확인")
    @Test
    void getProfitRate() {
        // given
        Result[] results = Result.values();
        int userLottoNumbers = 1000;
        // when
        double profitRate = Result.getProfitRate(results, userLottoNumbers);
        // then
        assertEquals(0.0, profitRate);
    }


}