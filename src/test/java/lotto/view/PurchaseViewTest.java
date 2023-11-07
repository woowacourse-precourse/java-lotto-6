package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.consts.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseViewTest extends NsTest {
    private int money;
    @DisplayName("구입 금액을 받아온다")
    @Test
    void purchaseView_구입금액_입력() {
        assertSimpleTest(() -> {
            run("1000");
            assertThat(money).isEqualTo(1000);
        });
    }

    @DisplayName("구입 금액이 숫자가 아닐 경우, 예외 처리")
    @Test
    void purchaseView_구매가격_숫자_아닐때() {
        assertSimpleTest(() -> {
            runException("1000원");
            assertThat(output()).contains(ErrorMessage.ERROR_MESSAGE_INPUT_MUST_BE_NUMBER.getMessage());
        });
    }

    @DisplayName("구입 금액이 1000원 단위가 아닐 경우, 예외 처리")
    @Test
    void purchaseView_구매가격_천원_단위_아닐때() {
        assertSimpleTest(() -> {
            runException("2200");
            assertThat(output()).contains(ErrorMessage.ERROR_MESSAGE_AMOUNT_UNIT.getMessage());
        });
    }

    @DisplayName("구입 금액이 0일때, 예외 처리")
    @Test
    void purchaseView_구매가격_0일때() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ErrorMessage.ERROR_MESSAGE_BUY_MORE_THAN_ONE.getMessage());
        });
    }

    @Override
    protected void runMain() {
        money = PurchaseView.lotto();
    }
}
