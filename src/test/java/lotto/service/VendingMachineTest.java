package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import lotto.domain.Lottos;
import lotto.domain.wrapper.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VendingMachineTest extends NsTest {

    @DisplayName("구입 금액에 따라 구입한 개수만큼 로또가 랜덤 번호를 기반으로 생성된다.")
    @Test
    void getLottos() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(2000);
        VendingMachine vendingMachine = new VendingMachine(purchaseAmount);
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Lottos lottos = vendingMachine.getLottos();
                    System.out.println(lottos.toString());
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