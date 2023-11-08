package lotto.Model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static lotto.Global.LottoResult.FIRST_RESULT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LottoMachineTest {
    static LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
    static LottoResultGenerator lottoResultGenerator = new LottoResultGenerator();
    static LottoMachine lottoMachine = new LottoMachine(lottoVendingMachine, lottoResultGenerator);

    @Order(1)
    @Test
    void 로또_구매_검증() {
        int mount = 1;
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(lottoMachine.purchaseLottos(mount).size() == mount);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Order(2)
    @Test
    void 당첨_로또_비정상값_오류_검증() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;
        assertThatThrownBy(() -> lottoMachine.setWinningNumberInformation(winningLotto, bonusNumber)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Order(3)
    @Test
    void 로또_결과_생성_검증() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 9;
        lottoMachine.setWinningNumberInformation(winningLotto, bonusNumber);

        HashMap<String, Integer> result = lottoMachine.getLottoWinningResult();
        System.out.println(result);
        assertThat(result.get(FIRST_RESULT.name()).intValue() == 1);
    }

    @Order(4)
    @Test
    void 로또_수익률_검증() {
        float result = lottoMachine.getRateOfResult(lottoMachine.getLottoWinningResult());
        assertThat(result == 2000000000 / 1000 * 100);
    }
}