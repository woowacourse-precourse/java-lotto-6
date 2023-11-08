package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.constant.Error;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class TotalTest extends NsTest {

    @DisplayName("입력이 구분자로 끝날 경우 예외가 발생한다.")
    @Test
    void endsWithSeparator() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,");
            assertThat(output()).contains(Error.ENDS_WITH_SEPARATOR.getMessage());
        });
    }

    @DisplayName("구입 금액은 1000원 이상이어야 한다.")
    @Test
    void moreThanThousandPay() {
        assertSimpleTest(() -> {
            runException("100");
            assertThat(output()).contains(Error.MINIMUM_PAYMENT.getMessage());
        });
    }

    @DisplayName("구입 금액은 1000원 단위여야 한다.")
    @Test
    void payUnitOfThousand() {
        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains(Error.ONLY_VALUE_THOUSAND.getMessage());
        });
    }

    @DisplayName("")

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
