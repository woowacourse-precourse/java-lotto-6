package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    @Test
    @DisplayName("당첨 내역을 저장하는 자료구조를 초기화한다.")
    void 당첨_내역을_저장하는_맵을_초기화한다() {
        // given
        Map<WinningType, Integer> winningResult = new EnumMap<>(WinningType.class);

        // when
        Arrays.stream(WinningType.values())
                .forEach(winningType -> winningResult.put(winningType, 0));

        // then
        winningResult.forEach((key, value) -> {
            Assertions.assertThat(value).isEqualTo(0);
        });
    }

    @Test
    @DisplayName("당첨 등수와 각 금액을 통해 얻을 수 있는 수익의 총합을 계산한다.")
    void 당첨_내역으로_수익의_총합을_계산한다() {
        // given
        Map<WinningType, Integer> winningResult = new EnumMap<>(WinningType.class);
        Arrays.stream(WinningType.values())
                .forEach(winningType -> winningResult.put(winningType, 0));
        winningResult.put(WinningType.FOURTH, 1); // 50000
        winningResult.put(WinningType.FIFTH, 2); // 10000

        // then
        int sum = (int) winningResult.entrySet()
                .stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();

        // then
        Assertions.assertThat(sum).isEqualTo(60000);
    }
}
