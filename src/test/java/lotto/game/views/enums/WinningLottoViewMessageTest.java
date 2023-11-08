package lotto.game.views.enums;

import lotto.app.game.views.enums.WinningLottoViewMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningLottoViewMessageTest {

    @Test
    void calculationProfit으로_수익률안내문구_구할수있다() {
        String expected = "총 수익률은 62.5%입니다.";

        String actual = WinningLottoViewMessage.calculationProfit(5000, 8000);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}