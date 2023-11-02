package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class InputViewTest {
    @Test
    public void 구입_금액_입력_화면_생성_테스트() {
        InputView inputView = new InputView();
        assertThat(inputView.enterBudgetMessage()).isEqualTo("구입금액을 입력해 주세요.");
    }

    @Test
    public void 당첨_번호_입력_화면_생성_테스트() {
        InputView inputView = new InputView();
        assertThat(inputView.enterWinningLottoTicket()).isEqualTo("당첨 번호를 입력해 주세요.");
    }

    @Test
    public void 보너스_번호_입력_화면_생성_테스트() {
        InputView inputView = new InputView();
        assertThat(inputView.enterBonusNumber()).isEqualTo("보너스 번호를 입력해 주세요.");
    }
}
