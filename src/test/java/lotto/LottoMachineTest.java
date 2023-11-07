package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestableLottoMachine extends LottoMachine {
    @Override
    public void issue(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);  // 항상 동일한 번호 발급
            issuedLottos.add(new Lotto(numbers));
        }
    }
}

class LottoMachineTest {
    @Test
    void checkWinning() {
        TestableLottoMachine machine = new TestableLottoMachine();
        machine.issue(1);
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningResult result = machine.checkWinning(winningLotto, 7);
        // 당첨 결과가 null이 아닌지 확인
        assertNotNull(result);
    }

    @Test
    void issue() {
        TestableLottoMachine machine = new TestableLottoMachine();
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningResult resultBeforeIssue = machine.checkWinning(winningLotto, 7);
        // 아직 로또를 발급하지 않았으므로, 당첨 결과는 모두 0개여야 합니다.
        for (Rank rank : Rank.values()) {
            assertEquals(0, resultBeforeIssue.getRankCount(rank));
        }
        machine.issue(5);
        WinningResult resultAfterIssue = machine.checkWinning(winningLotto, 7);
        // 이제는 로또를 5개 발급하였으므로, 당첨 결과의 합계는 5개여야 합니다.
        int total = Arrays.stream(Rank.values()).mapToInt(resultAfterIssue::getRankCount).sum();
        assertEquals(5, total);
    }
}
