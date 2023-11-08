package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.interactor.Buyer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BuyerTest extends NsTest {

    private Buyer buyer;

    @DisplayName("투입된 돈은 1000단위로 나누어져야 한다.")
    @Test
    void shouldThrowExceptionIfMoneyIsNotDivisibleByThousand() {
        assertSimpleTest(() -> {
            runException("2500");
            assertThat(output()).contains("[ERROR] 천원 단위의 돈을 입력하세요.");
        });
    }


    @DisplayName("투입된 돈은 숫자로만 이루어져야 한다.")
    @Test
    void shouldThrowExceptionIfMoneyIsNotNumeric() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains("[ERROR] 입력 형식이 잘못되었습니다.");
        });
    }

    @Override
    public void runMain() {
        buyer = new Buyer();
    }
}
