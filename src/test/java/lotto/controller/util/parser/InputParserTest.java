package lotto.controller.util.parser;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    @DisplayName("정상 금액 변환")
    public void parseMoney() {
        InputParser inputParser = new InputParser();
        String money = "8000";

        int moneyInt = inputParser.parseMoney(money);

        Assertions.assertThat(moneyInt).isEqualTo(8000);
    }

    @Test
    @DisplayName("숫자가 아닌 금액 변환")
    public void parseMoneyFail() {
        InputParser inputParser = new InputParser();
        String money = "8000j";

        Assertions.assertThatThrownBy(() -> inputParser.parseMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상 로또 번호 변환")
    public void parseLottoNumber() {
        InputParser inputParser = new InputParser();
        String lotto = "1,2,3,4,5,6";

        List<Integer> lottoNumbers = inputParser.parseLottoNumbers(lotto);

        Assertions.assertThat(lottoNumbers)
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("잘못된 로또 번호 변환")
    public void parseLottoNumberFail() {
        InputParser inputParser = new InputParser();
        String lotto = "1,2,3,4,5,a";

        Assertions.assertThatThrownBy(() -> inputParser.parseLottoNumbers(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상 보너스 번호 변환")
    public void parseBonusNumber() {
        InputParser inputParser = new InputParser();
        String bonusNumber = "45";

        Integer bonusNumberInt = inputParser.parseBonusNumber(bonusNumber);

        Assertions.assertThat(bonusNumberInt)
                .isEqualTo(45);
    }

    @Test
    @DisplayName("잘못된 보너스 번호 변환")
    public void parseBonusNumberFail() {
        InputParser inputParser = new InputParser();
        String bonusNumber = "45a";

        Assertions.assertThatThrownBy(() -> inputParser.parseBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}