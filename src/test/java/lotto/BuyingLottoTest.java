package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.BuyingLotto;
import static lotto.constants.Error.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BuyingLottoTest extends NsTest {
    @DisplayName("로또 구입금액이 0 또는 음수이면 예외가 발생한다.")
    @Test
    void createBuyingPriceByNotPlusSign() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(NOT_PLUS_SIGN.getMessage());
        });
    }

    @DisplayName("로또 구입금액으로 발행할 수 있는 로또의 수를 알맞게 리턴한다.")
    @Test
    void testCalculateTicketNumber() {
        String input = "15000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BuyingLotto buyingLotto = new BuyingLotto();
        assertThat(buyingLotto.getTicketNumber()).isEqualTo(15);
    }

    @Override
    public void runMain() {
        new BuyingLotto();
    }
}
