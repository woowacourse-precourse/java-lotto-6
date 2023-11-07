package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @Test
    @DisplayName("로또 번호와 당첨번호를 통해 당첨결과를 도출한다")
    void testLottoRankGet() {
        Lotto lotto = new Lotto(List.of(5, 10, 15, 20, 25, 30));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(new Lotto(List.of(5, 10, 15, 20, 25, 30)),
                new Bonus(22));

        LottoRank result = LottoRank.get(winningLottoNumbers, lotto);
        LottoRank expected = LottoRank.FIRST;

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("2등 3등을 구별하여 도출한다. 2등의 경우")
    void testLottoRankGetCaseSecond() {
        Lotto lotto = new Lotto(List.of(5, 10, 15, 20, 25, 30));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(new Lotto(List.of(5, 10, 15, 20, 25, 33)),
                new Bonus(30));

        LottoRank result = LottoRank.get(winningLottoNumbers, lotto);
        LottoRank expected = LottoRank.SECOND;

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("2등 3등을 구별하여 도출한다. 3등일 경우")
    void testLottoRankGetCaseThird() {
        Lotto lotto = new Lotto(List.of(5, 10, 15, 20, 25, 30));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(new Lotto(List.of(5, 10, 15, 20, 25, 33)),
                new Bonus(44));

        LottoRank result = LottoRank.get(winningLottoNumbers, lotto);
        LottoRank expected = LottoRank.THIRD;

        assertThat(result).isEqualTo(expected);
    }
}
