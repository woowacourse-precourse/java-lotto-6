package lotto;

import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {
    @DisplayName("유효한 구입 금액 입력 시, 정상적으로 값을 반환하는지 확인")
    @Test
    void inputValidPurchaseAmount() {
        String input = "5000"; // 유효한 입력값
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        long purchaseAmount = InputView.inputPurchaseAmount();

        assertThat(purchaseAmount).isEqualTo(5000);
    }

    @DisplayName("당첨 번호 입력시, 정상적으로 값을 반환하는 지 확인")
    @Test
    void inputValidWinnerNumbers() {
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<Integer> winnerNumbers = InputView.inputWinningNumbers();

        assertThat(winnerNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

}
