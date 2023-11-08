package lotto.global;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    @DisplayName("로또 번호를 입력받아 로또 객체로 변환한다.")
    @Test
    void parseStringToLottoTest() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        Lotto lotto = Parser.parseStringToLotto(input); // parseStringToLotto 메서드 호출

        // then
        assertThat(lotto)
                .usingRecursiveComparison()
                .isEqualTo(Lotto.of(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("문자열 숫자를 입력 받아 정수형으로 변환한다.")
    @Test
    void parseStringToUnsignedInt() {
        // given
        String input = "1000";

        // when
        int result = Parser.parseStringToUnsignedInt(input);

        // then
        assertEquals(1000, result);
    }
}