package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.interactor.Buyer;
import lotto.interactor.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest extends NsTest {
    private LottoMachine lottomachine = new LottoMachine();

    @DisplayName("generateLotto는 6개의 숫자를 오름차순으로 정렬하여 반환해야 한다.")
    @Test
    void generateLotto_ShouldReturnSortedNumbers() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains(
                            "[8, 21, 23, 41, 42, 43]"
                    );
                },
                List.of(21, 8, 23, 43, 42, 41)
        );
    }
    @Override
    public void runMain() {
        lottomachine.generateLottos(1);
    }
}