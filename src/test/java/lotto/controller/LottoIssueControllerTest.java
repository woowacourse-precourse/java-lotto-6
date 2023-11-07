package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Lottos;
import lotto.util.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoIssueControllerTest {

    LottoIssueController controller = new LottoIssueController();

    @DisplayName("정상 금액을 입력 받았을 경우, 로또를 발급한다.")
    @Test
    void issueLottosByDividedThousand() {
        Lottos lottos = controller.issueLottos(2000);
        assertThat(lottos.issuedSize())
                .isEqualTo(2);
    }

    @DisplayName("1,000원으로 나눠떨어지지 않는 금액을 받으면, 예외가 발생한다.")
    @Test
    void issueLottosByCantDividedThousand() {
        assertThatThrownBy(() -> controller.issueLottos(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.MONEY_CANT_DIVIDE_ERROR.getMessage());
    }
}