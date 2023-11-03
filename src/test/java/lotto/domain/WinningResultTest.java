package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {

    private WinningResult winningResult;
    @BeforeEach
    @Test
    void initWinningResult() {
        winningResult = new WinningResult(List.of("1등","2등","3등"));
    }

    @Test
    void getCount() {
        assertThat(winningResult.getCount("1등")).isEqualTo(1);
    }

    @Test
    void createWinningResult() {
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
}