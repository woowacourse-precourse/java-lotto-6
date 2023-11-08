package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningAnalyzerTest {
    private WinningAnalyzer winningAnalyzer;

    @BeforeEach
    void setUp() {
        winningAnalyzer = new WinningAnalyzer();
    }

    @Test
    @DisplayName("당첨 내역 결과 도출")
    void compareAllLotto() {
        //Given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 7);
        List<Lotto> userlottos = new ArrayList<>();
        userlottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        userlottos.add(new Lotto( List.of(3, 5, 11, 16, 32, 38)));
        userlottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        userlottos.add(new Lotto( List.of(1, 8, 11, 31, 41, 42)));
        userlottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        userlottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        userlottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        userlottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        //When
        Map<Rank, Integer> result = winningAnalyzer.compareAllLotto(userlottos, winningLotto);
        //Then
        assertThat(result.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(result.get(Rank.NORANK)).isEqualTo(7);

    }

    @DisplayName("총 수익률 계산")
    @Test
    void calculateRate() {
        //Given
        Map<Rank,Integer> result  = new HashMap<>();
        result.put(Rank.FIRST,0);
        result.put(Rank.SECOND,0);
        result.put(Rank.THIRD,0);
        result.put(Rank.FOURTH,0);
        result.put(Rank.FIFTH,1);
        int inputMoney = 8000;
        //When
        double rate = winningAnalyzer.calculateRate(result, inputMoney);
        //Then
        assertThat(rate).isEqualTo(62.5);
    }
}