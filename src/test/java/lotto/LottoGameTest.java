package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
    }

    @Test
    void generateLottoNums_6개인지_확인() {
        List<Integer> lottoNums = lottoGame.generateLottoNums();

        assertThat(lottoNums.size()).isEqualTo(6);
    }

    @Test
    void generateLottoNums_범위가_1부터_45까지인지_확인() {
        List<Integer> lottoNums = lottoGame.generateLottoNums();

        boolean result = lottoNums.stream().allMatch(lottoNum -> lottoNum >= 1 && lottoNum <= 45);

        assertThat(result).isTrue();
    }

    @Test
    void generateLottoNums_중복_없는지_확인() {
        List<Integer> lottoNums = lottoGame.generateLottoNums();

        int result = new HashSet<>(lottoNums).size();

        assertThat(result).isEqualTo(lottoNums.size());
    }

    @Test
    void generateLottoNums_오름차순인지_확인() {
        List<Integer> lottoNums = lottoGame.generateLottoNums();
        List<Integer> resultList = new ArrayList<>(lottoNums);

        assertThat(resultList).allMatch(value -> value == lottoNums.get(resultList.indexOf(value)));
    }

    @ParameterizedTest
    @CsvSource({"1000, 1", "2000, 2", "8000, 8", "10000, 10", "150000, 150"})
    void getLottoCounts(int price, int answer) {
        int result = lottoGame.getLottoCounts(price);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    void getEarningRate_정상입력() {
        int price = 5000;
        List<Rank> ranks = List.of(Rank.SECOND, Rank.FIFTH);

        String result = lottoGame.getEarningRate(ranks, price);

        assertThat(result).isEqualTo("600100.0%");
    }

    @Test
    void getEarningRate_소수점_둘째자리_반올림_확인() {
        int price = 7000;
        List<Rank> ranks = List.of(Rank.FIFTH);

        String result = lottoGame.getEarningRate(ranks, price);

        assertThat(result).isEqualTo("71.4%");
    }

    @Test
    void getRankCount() {
        List<Rank> ranks = List.of(Rank.FIRST, Rank.FIRST, Rank.FIFTH);

        Map<Rank, Integer> result = lottoGame.getRankCount(ranks);

        assertThat(result.getOrDefault(Rank.FIRST, 0)).isEqualTo(2);
        assertThat(result.getOrDefault(Rank.SECOND, 0)).isEqualTo(0);
        assertThat(result.getOrDefault(Rank.THIRD, 0)).isEqualTo(0);
        assertThat(result.getOrDefault(Rank.FOURTH, 0)).isEqualTo(0);
        assertThat(result.getOrDefault(Rank.FIFTH, 0)).isEqualTo(1);
    }

    @Test
    void buyLottos() {
        int lottoCounts = 10;

        List<Lotto> result = lottoGame.buyLottos(lottoCounts);

        assertThat(result.size()).isEqualTo(lottoCounts);
    }
}