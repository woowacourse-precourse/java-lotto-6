package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.List;

public class LottoMachineTest extends NsTest {

    @Test
    @DisplayName("로또 머신 생성 확인")
    void createLottoMachine() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.setNumOfLotto(3);
        lottoMachine.setLottos();

        assertThat(lottoMachine.getNumOfLotto()).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 머신으로 생성된 로또 확인")
    void tmp() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
