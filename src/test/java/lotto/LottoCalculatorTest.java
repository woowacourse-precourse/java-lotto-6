package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCalculatorTest {

    private WinningNumber winningNumber;
    private LottoCalculator lottoCalculator;

    @BeforeEach
    void setup() {
        winningNumber = new WinningNumber();
        winningNumber.setNumbers(Arrays.asList(1, 5, 9, 15, 23, 43));
        winningNumber.setBonusNumber(8);

        lottoCalculator = new LottoCalculator();
        lottoCalculator.setWinningNumber(winningNumber);
    }

    @DisplayName("lotto와 WinningNumber는 정확히 5개의 번호가 일치한다.")
    @Test
    void getMatchCount5() {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 5, 9, 15, 23, 44)));
        assertThat(5).isEqualTo(lottoCalculator.getMatchCount(lotto));
    }

    @DisplayName("lotto와 WinningNumber는 정확히 4개의 번호가 일치한다.")
    @Test
    void getMatchCount4() {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 5, 9, 15, 22, 44)));
        assertThat(4).isEqualTo(lottoCalculator.getMatchCount(lotto));
    }

    @DisplayName("lotto와 WinningNumber는 정확히 3개의 번호가 일치한다.")
    @Test
    void getMatchCount3() {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 5, 9, 14, 22, 44)));
        assertThat(3).isEqualTo(lottoCalculator.getMatchCount(lotto));
    }

    @DisplayName("lotto와 WinningNumber는 정확히 2개의 번호가 일치한다.")
    @Test
    void getMatchCount2() {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 5, 8, 14, 22, 44)));
        assertThat(2).isEqualTo(lottoCalculator.getMatchCount(lotto));
    }

    @DisplayName("lotto와 WinningNumber는 정확히 1개의 번호가 일치한다.")
    @Test
    void getMatchCount1() {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 4, 8, 14, 22, 44)));
        assertThat(1).isEqualTo(lottoCalculator.getMatchCount(lotto));
    }

    @DisplayName("lotto와 WinningNumber는 일치하는 번호가 없다.")
    @Test
    void getMatchCount0() {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(2, 4, 8, 14, 22, 44)));
        assertThat(0).isEqualTo(lottoCalculator.getMatchCount(lotto));
    }

    @DisplayName("보너스 번호를 포함하고 있다면, True 를 반환한다.")
    @Test
    void getMatchBonusTrue() {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 8, 13, 20, 39)));
        assertThat(true).isEqualTo(lottoCalculator.getMatchBonus(lotto));
    }

    @DisplayName("보너스 번호를 포함하지 않는다면, False 를 반환한다.")
    @Test
    void getMatchBonusFalse() {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 7, 13, 20, 39)));
        assertThat(false).isEqualTo(lottoCalculator.getMatchBonus(lotto));
    }

    @DisplayName("주어진 번호에 알맞는 랭크를 반환한다.")
    @Test
    void getLottoRank() {
        List<Lotto> createdLotto = new ArrayList<>();
        createdLotto.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 7, 13, 20, 39)))); // 1, false
        createdLotto.add(new Lotto(new ArrayList<>(Arrays.asList(1, 5, 8, 12, 19, 30)))); // 2, false
        createdLotto.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 5, 9, 24, 44)))); // 3, false
        createdLotto.add(new Lotto(new ArrayList<>(Arrays.asList(1, 5, 8, 9, 24, 44)))); // 3, true
        createdLotto.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 5, 9, 15, 44)))); // 4, false
        createdLotto.add(new Lotto(new ArrayList<>(Arrays.asList(1, 5, 8, 9, 15, 44)))); // 4, true
        createdLotto.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 5, 9, 15, 23)))); // 5, false
        createdLotto.add(new Lotto(new ArrayList<>(Arrays.asList(1, 5, 8, 9, 15, 23)))); // 5, true
        createdLotto.add(new Lotto(new ArrayList<>(Arrays.asList(1, 5, 9, 15, 23, 43)))); // 6, false

        List<Rank> ranks = lottoCalculator.getLottoRanks(createdLotto);

        assertThat(Rank.EMPTY).isEqualTo(ranks.get(0));
        assertThat(Rank.EMPTY).isEqualTo(ranks.get(1));
        assertThat(Rank.FIFTH).isEqualTo(ranks.get(2));
        assertThat(Rank.FIFTH).isEqualTo(ranks.get(3));
        assertThat(Rank.FOURTH).isEqualTo(ranks.get(4));
        assertThat(Rank.FOURTH).isEqualTo(ranks.get(5));
        assertThat(Rank.THIRD).isEqualTo(ranks.get(6));
        assertThat(Rank.SECOND).isEqualTo(ranks.get(7));
        assertThat(Rank.FIRST).isEqualTo(ranks.get(8));
    }
}
