package lotto;

import lotto.model.LottoInputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoInputParserTest {
    @DisplayName("당첨 번호에 (빈)문자가 포함인 경우 예외가 발생한다.")
    @Test
    void createLottoByIncludingNotNumber() {
        assertThatThrownBy(() -> LottoInputParser.notNumber(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoInputParser.notNumber("1,2,3,,5,6"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoInputParser.notNumber("1,2,3,c,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}