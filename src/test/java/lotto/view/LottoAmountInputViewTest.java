package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

class LottoAmountInputViewTest {

    @Test
    @DisplayName("사용자에게 구입할 Lotto 금액은 1000원 단위이다.")
    public void requestLottoPurchaseAmount() {
        // given
        LottoAmountInputView lottoAmountInputView = new LottoAmountInputView();
        String input = "98000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when
        int amount = lottoAmountInputView.requestLottoPurchaseAmount();
        // then
        boolean isResult = amount % 1000 == 0;
        assertThat(isResult).isTrue();
    }

}