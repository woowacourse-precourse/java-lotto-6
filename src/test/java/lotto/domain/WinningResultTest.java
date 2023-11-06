package lotto.domain;

import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {

    private WinningResult winningResult;
    @BeforeEach
    @Test
    void initWinningResult() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            winningResult = new WinningResult(new LottoTickets(5), new WinningLotto(new Lotto("1,2,3,4,5,6"), new LottoNumber("7")));
        }, List.of(1,2,3,4,5,6), List.of(1,2,3,4,5,7), List.of(1,2,3,4,5,8),List.of(1,2,3,4,8,7), List.of(1,2,3,14,15,18));
    }

    @Test
    void studyMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", map.getOrDefault("1", 0) + 1);
        map.put("2", map.getOrDefault("2", 0) + 1);
        map.put("3", map.getOrDefault("3", 0) + 1);
        map.put("4", map.getOrDefault("4", 0) + 1);
        map.put("5", map.getOrDefault("5", 0) + 1);

        for(String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }

    @DisplayName("당첨된 로또 결과의 수 가져오는 함수")
    @Test
    void getCount() {
        assertThat(winningResult.getCount(Rank.FIRST)).isEqualTo(1);
        assertThat(winningResult.getCount(Rank.SECOND)).isEqualTo(1);
        assertThat(winningResult.getCount(Rank.THIRD)).isEqualTo(1);
        assertThat(winningResult.getCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(winningResult.getCount(Rank.FIFTH)).isEqualTo(1);
    }
}