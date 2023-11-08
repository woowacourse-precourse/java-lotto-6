package lotto.domain;

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
    @DisplayName("2개의 로또가 4등이고, 1개의 로또가 5등인 경우 수익은 6만원이다.")
    void FOURTH_하나와_FIFTH_두개의_당첨_내역의_수익_총합을_계산한다() {
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

    @Test
    @DisplayName("1개의 로또가 1등이고, 3개의 로또가 3등인 경우 수익은 20억 450만원이다.")
    void FIRST_하나와_THIRD_세개의_당첨_내역의_수익_총합을_계산한다() {
        // given
        Map<WinningType, Integer> winningResult = new EnumMap<>(WinningType.class);
        Arrays.stream(WinningType.values())
                .forEach(winningType -> winningResult.put(winningType, 0));
        winningResult.put(WinningType.FIRST, 1); // 20억
        winningResult.put(WinningType.THIRD, 3); // 150만원

        // then
        int sum = (int) winningResult.entrySet()
                .stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();

        // then
        Assertions.assertThat(sum).isEqualTo(2004500000);
    }

    @Test
    @DisplayName("8000원의 비용으로 로또를 구매하고 1개의 로또가 2등인 경우 수익률은 ")
    void 비용이_8000원이고_1개의_로또가_2등인_경우_수익률을_계산한다() {
        // given
        Cost cost = Cost.from(8000);

        Map<WinningType, Integer> result = new EnumMap<>(WinningType.class);
        Arrays.stream(WinningType.values())
                .forEach(winningType -> result.put(winningType, 0));
        result.put(WinningType.SECOND, 1); // 30000000원

        WinningResult winningResult = WinningResult.from(result);

        // then
        double earningsRate = winningResult.calculateEarningsRate(cost);

        // then
        Assertions.assertThat(earningsRate).isEqualTo(375000);
    }
}
