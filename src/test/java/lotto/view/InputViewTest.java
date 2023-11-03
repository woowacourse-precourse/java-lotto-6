package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.ErrorHeadMessage;
import lotto.model.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    String ERROR_HEAD_MESSAGE = ErrorHeadMessage.ERROR_HEAD_MESSAGE;
    private final InputStream originalSystemIn = System.in;

    private void provideInput(String inputData) {
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
    }

    @BeforeEach
    void init() {
        System.setIn(originalSystemIn);
    }

    @AfterEach
    void afterInit() {
        Console.close();
    }

    @Test
    @DisplayName("구매금액 입력 확인")
    void 구매금액_입력_확인() {
        provideInput("3000\n");
        int purchaseAmount = InputView.getPurchaseAmount();
        assertThat(purchaseAmount).isEqualTo(3000);
    }

    @Test
    @DisplayName("구매금액이 1000원 단위 아닐 경우 예외 확인")
    void 구매금액_단위_예외_확인() {
        provideInput("3500\n");
        assertThatThrownBy(() ->  InputView.getPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_HEAD_MESSAGE);
    }

    @Test
    @DisplayName("구매금액이 음수일 경우 예외 확인")
    void 구매금액_음수일_경우_예외_확인() {
        provideInput("-3500\n");
        assertThatThrownBy(() ->  InputView.getPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_HEAD_MESSAGE);
    }

    @Test
    @DisplayName("당첨번호 입력 확인")
    void 당첨번호_입력_확인() {
        provideInput("3,4,5,6,7,8\n");
        Lotto winningNumbers = InputView.getWinningNumbers();
        assertThat(winningNumbers.sortNumbers()).isEqualTo("3, 4, 5, 6, 7, 8");
    }

    @Test
    @DisplayName("보너스 번호 입력 확인")
    void 보너스_번호_입력_확인() {
        provideInput("3\n");
        int bonusNumber = InputView.getBonusNumber();
        assertThat(bonusNumber).isEqualTo(3);
    }
}