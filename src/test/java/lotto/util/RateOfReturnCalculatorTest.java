package lotto.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.WinnerRating;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RateOfReturnCalculatorTest {

    @Test
    void calculateRateOfReturn() {

        //given
        Lotto winnerLottoNumber = Lotto.issueLotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        Lotto lotto1 = Lotto.issueLotto(List.of(4, 5, 6, 7, 8, 9));
        Lotto lotto2 = Lotto.issueLotto(List.of(6, 7, 8, 9, 10, 11));
        Lotto lotto3 = Lotto.issueLotto(List.of(12, 13, 14, 15, 16, 17));
        Lotto lotto4 = Lotto.issueLotto(List.of(18, 19, 20, 21, 22, 23));
        Lotto lotto5 = Lotto.issueLotto(List.of(24, 25, 26, 27, 28, 29));
        Lotto lotto6 = Lotto.issueLotto(List.of(30, 31, 32, 33, 34, 35));
        Lotto lotto7 = Lotto.issueLotto(List.of(36, 37, 38, 39, 40, 41));
        Lotto lotto8 = Lotto.issueLotto(List.of(1, 2, 42, 43, 44, 45));

        List<Lotto> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(lotto1);
        lottoNumbers.add(lotto2);
        lottoNumbers.add(lotto3);
        lottoNumbers.add(lotto4);
        lottoNumbers.add(lotto5);
        lottoNumbers.add(lotto6);
        lottoNumbers.add(lotto7);
        lottoNumbers.add(lotto8);

        Map<WinnerRating, Integer> winners = new HashMap<>();
        WinnerJudgementer.judgeWinners(lottoNumbers, winnerLottoNumber, bonusNumber, winners);

        // when
        Double rateOfReturn = RateOfReturnCalculator.calculateRateOfReturn(winners, lottoNumbers.size());

        //then
        Assertions.assertThat(String.format("%.1f", rateOfReturn)).isEqualTo("62.5");
    }
}