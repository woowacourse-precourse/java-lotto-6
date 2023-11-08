package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.domain.vendingMachine.LottoVendingMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoVendingMachineTest extends NsTest {
    LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();

    @DisplayName("로또 생성기 작동 확인")
    @Test
    void createLotto() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(lottoVendingMachine.buyLotto(2000).get(0).getNumbers())
                            .contains(8, 21, 23, 41, 42, 43);

                    assertThat(lottoVendingMachine.buyLotto(2000).get(1).getNumbers())
                            .contains(3, 5, 11, 16, 32, 38);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38)
        );
    }

    @DisplayName("로또 가격에 딱 맞지 않는 금액 입력시 예외 발생")
    @Test
    void buyLottoIsEndWithLottoPrice() {
        assertThatThrownBy(() -> lottoVendingMachine.buyLotto(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}