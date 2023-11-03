package lotto.view;

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
    }

    @Test
    void getBuyingPrice_테스트() {
        provideInput("8000");

        String result = inputView.getBuyingPrice();
        assertThat(result).isEqualTo("8000");
    }

    void provideInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
