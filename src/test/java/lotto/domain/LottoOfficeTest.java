package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoOfficeTest {

    private final static List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    private final static int bonusNumber = 7;

    @Test
    @DisplayName("구입 로또들의 당첨 내역 기능 테스트")
    void getResultTest() {
        // given
        LottoOffice lottoOffice = new LottoOffice(winningNumbers, bonusNumber);
        List<Lotto> lottoList = new ArrayList<>(List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        ));

        Map<LottoRank, Integer> expected = new HashMap<>() {{
            put(LottoRank.FIRST_PLACE, 0);
            put(LottoRank.SECOND_PLACE, 0);
            put(LottoRank.THIRD_PLACE, 0);
            put(LottoRank.FOURTH_PLACE, 0);
            put(LottoRank.FIFTH_PLACE, 1);
        }};

        // then
        Map<LottoRank, Integer> result = lottoOffice.getResult(lottoList);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("총 수익률 계산하는 기능 테스트")
    void getYieldTest() {
        // given
        LottoOffice lottoOffice = new LottoOffice(winningNumbers, bonusNumber);
        List<Lotto> lottoList = new ArrayList<>(List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        ));

        double expected = 62.5;

        // when
        lottoOffice.getResult(lottoList);
        double result = lottoOffice.getYield(8000);

        // then
        assertThat(result).isEqualTo(expected);
    }
}