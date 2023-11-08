package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateMachineTest {

    @DisplayName("로또 번호들과 도메인 당첨 번호들을 비교한 결과를 담은 리스트를 반환한다.")
    @Test
    void createLottoResult() {
        List<List<Integer>> allLottoCollection = new ArrayList<>();
        allLottoCollection.add(List.of(1, 3, 5, 12, 34, 41));
        allLottoCollection.add(List.of(1, 2, 4, 5, 6, 7));
        List<Integer> winningNumbers = List.of(1, 2, 4, 5, 12, 41);

        CalculateMachine calculateMachine = new CalculateMachine(allLottoCollection, winningNumbers, 0);

        int[] lottoResult = calculateMachine.lottoResult();
        int[] expected = {0, 0, 2, 0, 0, 0};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], lottoResult[i]);
        }
    }

    @DisplayName("수익률을 계산한 값을 반환한다.")
    @Test
    void createProfitResult() {
        CalculateMachine calculateMachine = new CalculateMachine(null, null, 0);

        int[] lottoResult = {0, 0, 1, 0, 0, 0};
        int invest = 10000;

        double profitPercentage = calculateMachine.profitResult(invest, lottoResult);

        assertEquals(500.0, profitPercentage);
    }
}