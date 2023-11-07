package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import lotto.domain.Buy;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputServiceTest {
    InputService inputService = new InputService();

    @BeforeEach
    void beforeEach() {
        Console.close();
    }
    @DisplayName("구매 금액을 입력하면, 구매금액과 로또 장수를 가진 객체를 반환")
    @Test
    void returnBuy() {
        final byte[] buf = "14000\n".getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        Buy buy = inputService.enterMoney();
        Assertions.assertThat(buy.getCount()).isEqualTo(14);
    }

    @DisplayName("로또번호를 (,)를 입력하고, 보너스 번호를 입력하면 로또 번호를 가진 객체를 반환")
    @Test
    void returnWinningLotto() {
        final byte[] buf = "1,2,3,4,5,6\n7\n".getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        WinningLotto winningLotto = inputService.enterWinningLotto();
        Lotto winningNumber = winningLotto.getWinningNumber();
        Assertions.assertThat(winningNumber.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        Assertions.assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }
}
