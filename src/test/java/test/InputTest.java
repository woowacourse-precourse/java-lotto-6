package test;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.Buyer;
import domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest extends NsTest {
    @DisplayName("구입 금액 입력한다.")
    @Test
    void createpriceoflottotobuy() {
        Buyer buyer = new Buyer();
        run("1000");
        assertThat(buyer.getPrice()).isEqualTo(1000);

    }

    @Override
    protected void runMain() {}
}
