package lotto.method.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoWinningNumber;
import lotto.domain.Simulator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimulatorTest {
    private final Simulator simulator = new Simulator();
    private final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(); // 로또 당첨 번호
    private final List<Lotto> inputTestLottos = new ArrayList<>(); // 테스트 로또

    public SimulatorTest() {
        lottoWinningNumber.setLotto(new Lotto(List.of(1,2,3,4,5,6)));
        lottoWinningNumber.setBonusNumber(7);
    }

    @Test
    @DisplayName("6개 번호를 모두 맞췄을 시 2,000,000,000원 (1등 당첨)")
    void wonFirstPlace() {
        inputTestLottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        simulator.run(lottoWinningNumber, inputTestLottos);

        Assertions.assertThat(calculateTotalReturn())
                .isEqualTo(2000000000);
    }

    @Test
    @DisplayName("5개 번호와 보너스 번호를 맞췄을 시 30,000,000원 (2등 당첨)")
    void wonSecondPlace() {
        inputTestLottos.add(new Lotto(List.of(1,2,3,4,5,7)));
        simulator.run(lottoWinningNumber, inputTestLottos);

        Assertions.assertThat(calculateTotalReturn())
                .isEqualTo(30000000);
    }

    @Test
    @DisplayName("5개 번호를 맞췄을 시 1,500,000원 (3등 당첨)")
    void wonThirdPlace() {
        inputTestLottos.add(new Lotto(List.of(1,2,3,4,5,45)));
        simulator.run(lottoWinningNumber, inputTestLottos);

        Assertions.assertThat(calculateTotalReturn())
                .isEqualTo(1500000);
    }

    @Test
    @DisplayName("4개 번호를 맞췄을 시 50,000원 (4등 당첨)")
    void wonForthPlace() {
        inputTestLottos.add(new Lotto(List.of(1,2,3,4,44,45)));
        simulator.run(lottoWinningNumber, inputTestLottos);

        Assertions.assertThat(calculateTotalReturn())
                .isEqualTo(50000);
    }

    @Test
    @DisplayName("3개 번호를 맞췄을 시 5,000원 (5등 당첨)")
    void wonFifthPlace() {
        inputTestLottos.add(new Lotto(List.of(1,2,3,43,44,45)));
        simulator.run(lottoWinningNumber, inputTestLottos);

        Assertions.assertThat(calculateTotalReturn())
                .isEqualTo(5000);
    }

    @Test
    @DisplayName("4등 당첨 2개, 5등 당첨 4개 시 수익금 120,000원")
    void returnCalculation() {
        inputTestLottos.add(new Lotto(List.of(1,2,3,4,44,45)));
        inputTestLottos.add(new Lotto(List.of(1,2,3,4,44,45)));
        inputTestLottos.add(new Lotto(List.of(1,2,3,43,44,45)));
        inputTestLottos.add(new Lotto(List.of(1,2,3,43,44,45)));
        inputTestLottos.add(new Lotto(List.of(1,2,3,43,44,45)));
        inputTestLottos.add(new Lotto(List.of(1,2,3,43,44,45)));
        simulator.run(lottoWinningNumber, inputTestLottos);

        Assertions.assertThat(calculateTotalReturn())
                .isEqualTo(120000);
    }

    @Test
    @DisplayName("맞춘 번호가 2개 이하일 시 꽝")
    void none() {
        inputTestLottos.add(new Lotto(List.of(1,2,42,43,44,45)));
        inputTestLottos.add(new Lotto(List.of(1,41,42,43,44,45)));
        inputTestLottos.add(new Lotto(List.of(40,41,42,43,44,45)));
        simulator.run(lottoWinningNumber, inputTestLottos);

        Assertions.assertThat(calculateTotalReturn())
                .isEqualTo(0);
    }

    @Test
    @DisplayName("2000원 구매, 5000원 수익 시 수익률 250% (지불 금액 대비 수익금으로 수익률 계산)")
    void calculateRateOfReturn() {
        inputTestLottos.add(new Lotto(List.of(1,2,3,43,44,45)));
        inputTestLottos.add(new Lotto(List.of(1,41,42,43,44,45)));
        simulator.run(lottoWinningNumber, inputTestLottos);

        Assertions.assertThat(simulator.getRateOfReturn())
                .isEqualTo(250);
    }

    private int calculateTotalReturn() {
        Map<LottoRank, Integer> lottoRankResult = simulator.getLottoRankResult();
        return lottoRankResult.entrySet().stream()
                .mapToInt(rank -> rank.getKey().price() * rank.getValue())
                .sum();
    }
}