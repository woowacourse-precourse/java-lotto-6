package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.model.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    private void setInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @DisplayName("구입금액 입력 확인")
    @Test
    void readPurchaseAmount() {
        String input = "5000";
        setInput(input);

        int purchaseAmount = inputView.readPurchaseAmount();

        assertThat(purchaseAmount).isEqualTo(5000);
    }

    @DisplayName("당첨 번호 입력 확인")
    @Test
    void readWinningNumbers() {
        String input = "1, 2, 3, 4, 5, 6";
        setInput(input);

        Lotto lotto = inputView.readWinningNumbers();

        assertThat(lotto).isNotNull();
    }

    @DisplayName("보너스 번호 입력 확인")
    @Test
    void readBonusNumber() {
        String input = "7";
        setInput(input);

        int bonusNumber = inputView.readBonusNumber();

        assertThat(bonusNumber).isEqualTo(7);
    }


    @AfterEach
    void closeConsole() {
        Console.close();
    }

}