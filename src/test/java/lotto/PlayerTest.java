package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest extends NsTest {
    @DisplayName("로또 구입 금액이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void payTicketPriceByIsDigit() {
        assertThatThrownBy(
                () -> {
                    runException("천원");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void payTicketPriceByUnitOf1000won() {
        assertThatThrownBy(
                () -> {
                    runException("1001");
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Player player = new Player();
        player.payTicketPrice();
    }
}