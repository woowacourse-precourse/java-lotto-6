package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class InputManagerTest {
    private InputManager inputManager = InputManager.getInstance();

    @DisplayName("복권 구입 금액을 입력 받는다.")
    @Test
    void getPurchaseAmount() {
        assertThat(inputManager.getPurchaseAmount("8000")).isEqualTo(8);
    }

    @DisplayName("입력받은 당첨번호를 정수 리스트 형태로 얻는다.")
    @Test
    void getWinningNumbers() {
        String data = "1,2,3,4,5";

        List<Integer> winningNumbers = inputManager.getWinningNumbers(data);

        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5);
    }

    @DisplayName("입력받은 보너스 번호를 정수 형태로 얻는다.")
    @Test
    void getBonusNumber() {
        String data = "1";

        int bonusNumber = inputManager.getBonusNumber(data);

        assertThat(bonusNumber).isEqualTo(1);
    }
}