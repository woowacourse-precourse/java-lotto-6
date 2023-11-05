package lotto.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoInputViewTest {
    private final LottoInputView lottoInputView = new LottoInputView();

    @DisplayName("로또 번호 입력에 문자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void getWinningNumbersIncludeCharacter() {
        String userInput = "1,2,3,4,5,6A";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(lottoInputView::getWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class);
    }

}