package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.utils.MessageConstant;
import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LottoServiceTest {
    private LottoService lottoService;
    private InputView inputView;

    @BeforeEach
    public void setUp() {
        inputView = mock(InputView.class);
        lottoService = new LottoService(inputView);
    }

    @DisplayName("사용자가 올바른 구입 금액을 입력한다.")
    @Test
    void inputMoney() {
        when(inputView.inputNumber(MessageConstant.INPUT_PURCHASE_AMOUNT)).thenReturn(10000);

        Money money = lottoService.inputMoney();

        assertThat(money.getPurchaseMoney()).isEqualTo(10000);
    }

    @DisplayName("사용자가 올바르지 않은 금액을 입력하면 함수가 재호출 되어야 한다.")
    @Test
    void inputMoneyByInvalidInput() {
        when(inputView.inputNumber(MessageConstant.INPUT_PURCHASE_AMOUNT)).thenReturn(0, 100, 1000);

        Money money = lottoService.inputMoney();

        verify(inputView, times(3)).inputNumber(MessageConstant.INPUT_PURCHASE_AMOUNT);
    }

    @DisplayName("사용자가 로또를 구입한다.")
    @Test
    void buy() {
        Money money = new Money(1000);
        Lottos lottos = lottoService.buy(money);

        assertThat(lottos.getLottos().size()).isEqualTo(1);
    }

    @DisplayName("당첨 로또를 생성한다.")
    @Test
    void setWinningLotto() {
        when(inputView.inputNumbers(MessageConstant.INPUT_WINNING_NUMBERS)).thenReturn(List.of(1,2,3,4,5,6));
        when(inputView.inputNumber(MessageConstant.INPUT_BONUS_NUMBER)).thenReturn(7);

        WinningLotto winningLotto = lottoService.setWinningLotto();

        assertThat(winningLotto.bonus()).isEqualTo(7);
    }
}
