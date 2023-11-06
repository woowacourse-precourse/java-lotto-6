package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LottoInputViewTest {

    @Test
    @DisplayName("성공적으로 구매할 로또 수를 반환 해야 한다")
    public void 성공적으로_구매할_로또_수를_반환_해야_한다() {
        MockedStatic<Console> randomsMockedStatic = mockStatic(Console.class);
        LottoInputView lottoInputView = new LottoInputView();

        when(Console.readLine()).thenReturn("8");
        Long lottoPurchaseAmountInput = lottoInputView.getLottoPurchaseAmountInput();

        assertThat(lottoPurchaseAmountInput).isEqualTo(8L);
        randomsMockedStatic.close();
    }

    @Test
    @DisplayName("성공적으로 WinningNumber를 반환 해야 한다")
    public void 성공적으로_WinningNumber를_반환_해야_한다() {
        MockedStatic<Console> randomsMockedStatic = mockStatic(Console.class);
        LottoInputView lottoInputView = new LottoInputView();

        when(Console.readLine()).thenReturn("1, 2, 3, 4, 5, 6");
        List<Integer> winningNumbers = lottoInputView.getWinningNumbers();

        assertThat(winningNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        randomsMockedStatic.close();
    }

}
