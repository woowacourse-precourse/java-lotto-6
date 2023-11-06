package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        int purchaseAmount = inputView.inputPurchasePrice();

        // then
        assertThat(purchaseAmount).isEqualTo(correctAnswer);
        assertThat(purchaseAmount).isNotEqualTo(wrongAnswer);
    }

    @Test
    @DisplayName("당첨 번호를 입력받는다.")
    void inputWinningNumbers() {
        // given
        System.setIn(new ByteArrayInputStream("1,2,3,4,5,6".getBytes()));
        List<Integer> correctAnswer = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> wrongAnswer = List.of(6, 5, 4, 3, 2, 1);

        // when
        List<Integer> inputWinningNumbers = inputView.inputWinningNumbers();

        // then
        assertThat(inputWinningNumbers).isEqualTo(correctAnswer);
        assertThat(inputWinningNumbers).isNotEqualTo(wrongAnswer);
    }

    @Test
    @DisplayName("보너스 번호를 입력받는다.")
    void inputBonusNumber() {
        // given
        System.setIn(new ByteArrayInputStream("31".getBytes()));
        int correctAnswer = 31;
        int wrongAnswer = 41;

        // when
        int bonusNumber = inputView.inputBonusNumber();

        // then
        assertThat(bonusNumber).isEqualTo(correctAnswer);
        assertThat(bonusNumber).isNotEqualTo(wrongAnswer);
    }
}