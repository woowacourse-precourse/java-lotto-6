package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoInputViewTest {
    private InputStream old;
    private LottoInputView inputView;

    @BeforeEach
    void setUp() {
        old = System.in;
        inputView = new LottoInputView();
    }

    @AfterEach
    void restore() {
        System.setIn(old);
        Console.close();
    }

    @Test
    void getBuyingPrice_테스트() {
        String input = "8000";
        provideInput(input);

        String result = inputView.getBuyingPrice();
        assertThat(result).isEqualTo(input);
    }

    @Test
    void getLottoWinningNumbers_테스트() {
        String input = "1,2,3,4,5,6";
        provideInput(input);

        String result = inputView.getLottoWinningNumbers();
        assertThat(result).isEqualTo(input);
    }

    @Test
    void getBonusNumber_테스트() {
        String input = "40";
        provideInput(input);

        String result = inputView.getBonusNumber();
        assertThat(result).isEqualTo(input);
    }

    void provideInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
