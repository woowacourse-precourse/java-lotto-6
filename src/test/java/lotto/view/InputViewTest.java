package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import lotto.view.input.AmountInputView;
import lotto.view.input.BonusInputView;
import lotto.view.input.LottoInputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private final InputStream originalSystemIn = System.in;

    @BeforeEach
    void setUpStreams() {
        System.setIn(originalSystemIn);
    }

    @AfterEach
    void restoreSystemInStream() {
        System.setIn(originalSystemIn);
    }

    @DisplayName("입력시 결과 도출")
    @Test
    void giveInputNumber() {
        String input = "2000\n10000\n1000\n10, 1, 9, 2, 39, 4\n13\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        if (input.contentEquals("2000")) {
            assertThat(new AmountInputView().getNumberOfLotto())
                    .isEqualTo(2);
        }
        if (input.contentEquals("10000")) {
            assertThat(new AmountInputView().getNumberOfLotto())
                    .isEqualTo(10);
        }
        if (input.contentEquals("1000")) {
            assertThat(new AmountInputView().getNumberOfLotto())
                    .isEqualTo(1);
        }
        if (input.contentEquals("13")) {
            assertThat(new BonusInputView().getBonusNumber())
                    .isEqualTo(13);
        }
        if (input.contentEquals("10, 1, 9, 2, 39, 4")) {
            assertThat(new LottoInputView().getLottoNumbers())
                    .isEqualTo(List.of(10, 1, 9, 2, 39, 4));
        }
    }
}
