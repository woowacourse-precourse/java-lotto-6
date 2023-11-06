package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    InputView inputView = new InputView();

    @Test
    @DisplayName("로또 구입 금액을 입력받는다.")
    void inputPurchaseAmount() {
        // given
        System.setIn(new ByteArrayInputStream("14000".getBytes()));
        int correctAnswer = 14000;
        int wrongAnswer = 10000;

        // when
        int purchaseAmount = inputView.inputPurchaseAmount();

        // then
        assertThat(purchaseAmount).isEqualTo(correctAnswer);
        assertThat(purchaseAmount).isNotEqualTo(wrongAnswer);
    }
}