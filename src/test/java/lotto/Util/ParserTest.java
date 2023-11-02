package lotto.Util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {
    
    @Test
    @DisplayName("문자열 1000의 배수 변환 테스트")
    public void convertStringToThousandsMultipleTest() {
        String input = "19000";
        int expect = 19;

        assertThat(Parser.convertStringToThousandsMultiple(input)).isEqualTo(expect);
    }
}
