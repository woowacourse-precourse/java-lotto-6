package lotto.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.view.parser.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserTest {
    @DisplayName("구입 금액에 공백이 포함된 경우, 공백을 제거한 값을 숫자 타입으로 바꾸어 돌려준다.")
    @Test
    void removeBlankAndReturnToNumericValueIfInsertedUserMoneyInputHasBlanks() {
        // given
        String userInput = "10 00 00";

        // when
        long userMoney = new InputParser().parseUserMoney(userInput);

        // then
        assertThat(userMoney).isEqualTo(100000L);
    }

    @DisplayName("당첨번호 입력값 중간에 공백이 포함된 경우, 공백을 제거한 뒤 숫자 타입 리스트로 바꾸어 돌려준다.")
    @Test
    void removeBlankAndReturnToNumericValuesIfInsertedWinningLottoNumbersInputHaveBlanks() {
        // given
        String userInput = "  1, 2 , 3     , 4   ,  5,  6";

        // when
        List<Integer> userMoney = new InputParser().parseWinningLottoNumbers(userInput);

        // then
        assertThat(userMoney).containsAll(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호에 공백이 포함된 경우, 공백을 제거한 값을 숫자 타입으로 바꾸어 돌려준다.")
    @Test
    void removeBlankAndReturnToNumericValueIfInsertedBonusNumberInputHasBlanks() {
        // given
        String userInput = "    4          2      ";

        // when
        int bonusNumber = new InputParser().parseBonusNumber(userInput);

        // then
        assertThat(bonusNumber).isEqualTo(42);
    }
}