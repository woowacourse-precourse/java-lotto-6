package lotto.Model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static lotto.Global.LottoResult.FIRST_RESULT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LottoMachineTest {
    static LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
    static LottoResultGenerator lottoResultGenerator = new LottoResultGenerator();
    static LottoMachine lottoMachine = new LottoMachine(lottoVendingMachine, lottoResultGenerator);

    @DisplayName("로또 구매과정을 검증")
    @Order(1)
    @Test
    void lottoBuy() {
        int mount = 1;
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(lottoMachine.purchaseLottos(mount).size() == mount);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("당첨 로또 번호로 비정상값이 들어왔을 때를 검증")
    @Order(2)
    @Test
    void winningLottoNumberInvalidate() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;
        assertThatThrownBy(() -> lottoMachine.setWinningNumberInformation(winningLotto, bonusNumber)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("로또 추첨 결과 생성 로직을 검증")
    @Order(3)
    @Test
    void winningResult() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 9;
        lottoMachine.setWinningNumberInformation(winningLotto, bonusNumber);

        HashMap<String, Integer> result = lottoMachine.getLottoWinningResult();
        System.out.println(result);
        assertThat(result.get(FIRST_RESULT.name()).intValue() == 1);
    }

    @DisplayName("로또 수익률 계산 로직을 검증")
    @Order(4)
    @Test
    void rateOfResult() {
        float result = lottoMachine.getRateOfResult(lottoMachine.getLottoWinningResult());
        assertThat(result == 2000000000 / 1000 * 100);
    }
}