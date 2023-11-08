package lotto.Model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoVendingMachineTest {
    static LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();

    @Test
    void createLotto() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottoVendingMachine.createValidLotto().getLottoCreatedResult().equals("[1, 2, 3, 4, 5, 6]");
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

}