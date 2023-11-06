package lotto.util;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    @DisplayName("구입 금액을 문자열에서 정수로 변환한다.")
    @Test
    void parsePurchaseAmount_String_To_Integer() {
        assertThat(InputParser.parsePurchaseAmount("1000"))
            .isEqualTo(1000);
    }

    @DisplayName("당첨 번호를 문자열에서 정수형 리스트로 변환한다.")
    @Test
    void parseWinningNumbers_String_To_List() {
        assertThat(InputParser.parseWinningNumbers("1,2,3,4,5,6"))
            .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호를 문자열에서 정수로 변환한다.")
    @Test
    void parseBonusNumber_String_To_Integer() {
        assertThat(InputParser.parseBonusNumber("1"))
            .isEqualTo(1);
    }

}