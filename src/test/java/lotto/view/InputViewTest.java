package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import lotto.ErrorHeadMessage;
import lotto.model.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    String ERROR_HEAD_MESSAGE = ErrorHeadMessage.ERROR_HEAD_MESSAGE;
    private final InputStream originalSystemIn = System.in;
    InputView inputView = new InputView();

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
        int purchaseAmount = inputView.getPurchaseAmount();
        assertThat(purchaseAmount).isEqualTo(3000);
    }

    @Test
    @DisplayName("구매금액이 1000원 단위 아닐 경우 예외 확인")
    void 구매금액_단위_예외_확인() {
        provideInput("3500\n");
        assertThatThrownBy(() ->  inputView.getPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_HEAD_MESSAGE);
    }

    @Test
    @DisplayName("구매금액이 음수일 경우 예외 확인")
    void 구매금액_음수일_경우_예외_확인() {
        provideInput("-3500\n");
        assertThatThrownBy(() ->  inputView.getPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_HEAD_MESSAGE);
    }

    @Test
    @DisplayName("당첨번호 입력 확인")
    void 당첨번호_입력_확인() {
        provideInput("3,4,5,6,7,8\n");
        Lotto winningNumbers = inputView.getWinningNumbers();
        assertThat(winningNumbers.sortNumbers()).isEqualTo("3, 4, 5, 6, 7, 8");
    }

    @Test
    @DisplayName("보너스 번호 입력 확인")
    void 보너스_번호_입력_확인() {
        provideInput("7\n");
        List<Integer> winningLotto = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            winningLotto.add(i);
        }
        int bonusNumber = inputView.getBonusNumber(winningLotto);
        assertThat(bonusNumber).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호 중복 입력인 경우 에러 확인")
    void 보너스_번호_중복_입력_에러_확인() {
        provideInput("3\n");
        List<Integer> winningLotto = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            winningLotto.add(i);
        }
        assertThatThrownBy(() -> inputView.getBonusNumber(winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_HEAD_MESSAGE);
    }

    @Test
    @DisplayName("보너스 번호 음수인 경우 에러 확인")
    void 보너스_번호_음수_입력_에러_확인() {
        provideInput("-1\n");
        List<Integer> winningLotto = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            winningLotto.add(i);
        }
        assertThatThrownBy(() -> inputView.getBonusNumber(winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_HEAD_MESSAGE);
    }

    @Test
    @DisplayName("보너스 번호 1~45 사이의 수가 아닌 경우 에러 확인")
    void 보너스_번호_범위밖_입력_에러_확인() {
        provideInput("47\n");
        List<Integer> winningLotto = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            winningLotto.add(i);
        }
        assertThatThrownBy(() -> inputView.getBonusNumber(winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_HEAD_MESSAGE);
    }

    @Test
    @DisplayName("보너스 번호 숫자가 아닌 경우 에러 확인")
    void 보너스_번호_문자_입력_에러_확인() {
        provideInput("40a\n");
        List<Integer> winningLotto = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            winningLotto.add(i);
        }
        assertThatThrownBy(() -> inputView.getBonusNumber(winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_HEAD_MESSAGE);
    }
}