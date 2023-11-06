package lotto;

import lotto.util.LottoParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoParserTest {
    @DisplayName("입력으로 주어진 문자열 내부에 숫자가 아닌 다른 형식의 입력이 포함된 경우 예외가 발생한다.")
    @Test
    void parseInputsNotNumeric(){
        String input = "1,2,3,4,5,a";
        Assertions.assertThatThrownBy(() -> LottoParser.parseWinningInputs(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
