package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class PurchaseLottoTest extends NsTest {
    private static Purchase purchase;
    private static final String stop = "3000";
    private static final String amount = "3";

    @DisplayName("구입 금액 입력 시 문자를 입력하면 오류 메시지를 출력한다.")
    @Test
    void inputString() {
        String input = "Anakin";

        assertSimpleTest(() -> {
            run(input, stop);
            assertThat(output())
                .contains("[ERROR] 숫자를 입력하세요.");
        });
    }

    @DisplayName("구입 금액 입력 시 음수를 입력하면 오류 메시지를 출력한다.")
    @Test
    void inputNegative() {
        String input = "-4000";

        assertSimpleTest(() -> {
            run(input, stop);
            assertThat(output())
                .contains("[ERROR] 금액은 음수일 수 없습니다.");
        });
    }

    @DisplayName("구입 금액 입력 시 1000으로 나누어 떨어지지 않는 수를 입력하면 오류 메시지를 출력한다.")
    @Test
    void inputRemain() {
        String input = "3456";

        assertSimpleTest(() -> {
            run(input, stop);
            assertThat(output())
                .contains("[ERROR] 금액은 천 단위의 수여야 합니다.");
        });
    }

    @DisplayName("올바른 금액을 입력한 경우 구매한 로또의 개수를 출력한다.")
    @Test
    void inputCorrect() {
        assertSimpleTest(() -> {
            run(stop);
            assertThat(output())
                .contains(amount);
        });
    }

    @Override
    public void runMain() {
        purchase = new Purchase();
        purchase.getTickets();
    }
}
